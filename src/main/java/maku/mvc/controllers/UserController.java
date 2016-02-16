package maku.mvc.controllers;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import maku.mvc.config.ImageHandler;
import maku.mvc.config.ImageUploadException;
import maku.mvc.entities.Post;
import maku.mvc.entities.Role;
import maku.mvc.entities.User;
import maku.mvc.services.PostService;
import maku.mvc.services.RoleService;
import maku.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    
    @Autowired
    UserService userService;

    @Autowired
    PostService postService;
    
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        ModelAndView model = new ModelAndView();
        List<User> users = userService.getAll();
        Collections.sort(users, (User u1, User u2) -> {
            return u1.getName().compareTo(u2.getName());
        });
        model.addObject("users", users);
        model.setViewName("main_users");
        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserForm(@Valid User user,
            BindingResult result,
            Model model,
            RedirectAttributes attributes,
            HttpSession session,
            @RequestParam(value = "image", required = false) MultipartFile image) {

        
        if (result.hasErrors()) {
            model.addAttribute("registerError", "Niepoprawnie wypełnione pola :");
            return "register";
        }
        if (userService.getByName(user.getName()) != null) {
            model.addAttribute("registerError", "Taki użytkownik już istnieje!");
            return "register";
        }
        if (!user.getPassword().equals(user.getRepeatPassword())) {
            model.addAttribute("registerError", "Wpisane hasła nie są takie same!");
            return "register";
        }
        if (!image.isEmpty()) {
            try {
                ImageHandler.validate(image);
            } catch (ImageUploadException e) {
                model.addAttribute("registerError", e.getMessage());
                return "register";
            }
        }

        Role role = roleService.getByAuthority("ROLE_USER");
        user.setEnabled(true);
        user.setImageName("user_default.jpg");
        userService.persist(user);
        user.getRoles().add(role);
        userService.merge(user);

        String webResourcePath = session.getServletContext().getRealPath("/resources/upload/");
        if (!image.isEmpty()) {
            try {
                ImageHandler.save("user" + user.getId() + ".jpg", webResourcePath, image);
                user.setImageName("user" + user.getId() + ".jpg");
                userService.merge(user);
                attributes.addFlashAttribute("message", "Zarejestrowano nowego użytkownika! Możesz się teraz zalogować.");
            } catch (ImageUploadException e) {
                userService.delete(user);
                attributes.addFlashAttribute("message", e.getMessage());
            }
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ModelAndView showUser(@PathVariable(value = "userId") Long userId,
            HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        User user = userService.getById(userId);;
        List<Post> posts = postService.getPostsByUser(user);
        model.addObject("user", user);
        if (user.isEnabled()) {
            model.addObject("status", "Aktywne");
        } else {
            model.addObject("status", "Nieaktywne");
        }
        Predicate<Role> isAdminTest = (Role role) -> (role.getAuthority().equals("ROLE_ADMIN"));
        List<Role> roles = user.getRoles();
        boolean isAdmin = user.getRoles().stream().anyMatch(isAdminTest);
        if (isAdmin) {
            model.addObject("userRole", "Admin");
        } else {
            model.addObject("userRole", "Użytkownik");
        }
        model.addObject("isAdminUser", isAdmin);
        if (posts != null) {
            model.addObject("numberOfPosts", postService.getPostsByUser(user).size());
        } else {
            model.addObject("numberOfPosts", 0);
        }
        model.setViewName("user");
        return model;
    }

    @RequestMapping(value = "/user/{userId}/deleteAvatar", method = RequestMethod.GET)
    public ModelAndView deleteImage(@PathVariable(value = "userId") Long userId, HttpSession session, RedirectAttributes attributes) {
        ModelAndView model = new ModelAndView();
        User user = userService.getById(userId);
        if (ImageHandler.delete(userService.getById(userId).getImageName(), session.getServletContext().getRealPath("/resources/") + "/upload/")) {
            user.setImageName("user_default.jpg");
            userService.merge(user);
        }
        model.setViewName("redirect:/user/" + userId);
        return model;
    }

    @RequestMapping(value = "/user/{userId}/updateAvatar", method = RequestMethod.GET)
    public String changeAvatar(@PathVariable(value = "userId") Long userId) {
        return "changeAvatar";
    }

    @RequestMapping(value = "/user/{userId}/updateAvatar", method = RequestMethod.POST)
    public ModelAndView changeAvatarForm(@PathVariable(value = "userId") Long userId,
            @RequestParam(value = "image") MultipartFile image,
            HttpSession session,
            RedirectAttributes attributes) {

        ModelAndView model = new ModelAndView();
        String uploadPath = session.getServletContext().getRealPath("/resources/upload/");
        model.setViewName("changeAvatar");
        if (image.isEmpty()) {
            model.addObject("error", "Nie wybrano żadnego obrazka!");
            return model;
        }
        try {
            ImageHandler.validate(image);
        } catch (ImageUploadException ex) {
            model.addObject("error", ex.getMessage());
            return model;
        }
        User user = userService.getById(userId);
        model.setViewName("redirect:/user/" + userId);
        if (!user.getImageName().equals("user_default.jpg")) {
            if(!ImageHandler.delete(user.getImageName(), uploadPath)) {
                attributes.addFlashAttribute("error", "Nie udało się usunąć starego awatara!");
            }
        }
        try {
            ImageHandler.save("user" + user.getId() + ".jpg", uploadPath, image);
            user.setImageName("user" + user.getId() + ".jpg");
            userService.merge(user);
        } catch (ImageUploadException ex) {
            attributes.addFlashAttribute("error", ex.getMessage());
        }
        attributes.addFlashAttribute("success", "Pomyślnie zmieniono awatar!");
        return model;
    }

}

package maku.mvc.controllers;

import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import maku.mvc.config.ImageHandler;
import maku.mvc.config.ImageUploadException;
import maku.mvc.dao.UserDao;
import maku.mvc.domain.Post;
import maku.mvc.domain.PostDao;
import maku.mvc.domain.Role;
import maku.mvc.domain.User;
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
    UserDao userDao;

    @Autowired
    PostDao postDao;

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
        if (userDao.getUserByName(user.getName()) != null) {
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

        Role role = userDao.getRoleByAuthority("ROLE_USER");
        user.setEnabled(true);
        user.setImageName("user_default.jpg");
        userDao.addUser(user);
        user.getRoles().add(role);
        userDao.saveUser(user);

        String webResourcePath = session.getServletContext().getRealPath("/resources/");
        if (!image.isEmpty()) {
            try {
                ImageHandler.save("user" + user.getId() + ".jpg", webResourcePath + "/upload/", image);
                user.setImageName("user" + user.getId() + ".jpg");
                userDao.saveUser(user);
                attributes.addFlashAttribute("message", "Zarejestrowano nowego użytkownika! Możesz się teraz zalogować.");
            } catch (ImageUploadException e) {
                userDao.deleteUser(user);
                attributes.addFlashAttribute("message", e.getMessage());
            }
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ModelAndView showUser(@PathVariable(value = "userId") Long userId,
            HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        User user = userDao.getUserById(userId);;
        List<Post> posts = postDao.getByUser(user);
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
            model.addObject("numberOfPosts", postDao.getByUser(user).size());
        } else {
            model.addObject("numberOfPosts", 0);
        }
        model.setViewName("user");
        return model;
    }

    @RequestMapping(value = "/user/{userId}/deleteAvatar", method = RequestMethod.GET)
    public ModelAndView deleteImage(@PathVariable(value = "userId") Long userId, HttpSession session, RedirectAttributes attributes) {
        ModelAndView model = new ModelAndView();
        User user = userDao.getUserById(userId);
        if (ImageHandler.delete(userDao.getUserById(userId).getImageName(), session.getServletContext().getRealPath("/resources/") + "/upload/")) {
            user.setImageName("user_default.jpg");
            userDao.saveUser(user);
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
        String resourcePath = session.getServletContext().getRealPath("/resources/");
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
        User user = userDao.getUserById(userId);
        model.setViewName("redirect:/user/" + userId);
        if(ImageHandler.update(user.getImageName(), resourcePath + "/upload/", image)) {
            model.addObject("error", "Nie udało się zmienić awatara!");
        }
        return model;
    }
}

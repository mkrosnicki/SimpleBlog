package maku.mvc.controllers;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import maku.mvc.config.ImageOperationException;
import maku.mvc.constants.Constants;
import maku.mvc.entities.Post;
import maku.mvc.entities.Role;
import maku.mvc.entities.User;
import maku.mvc.services.CommentService;
import maku.mvc.services.ImageService;
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

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        ModelAndView model = new ModelAndView();
        List<User> users = userService.getSortedByName();
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
            model.addAttribute("registerError", "Niepoprawnie wype³nione pola :");
            return "register";
        }
        if (userService.getByName(user.getName()) != null) {
            model.addAttribute("registerError", Constants.USER_EXISTS_ERROR);
            return "register";
        }
        if (!user.getPassword().equals(user.getRepeatPassword())) {
            model.addAttribute("registerError", Constants.PASSWORDS_DONT_MATCH_ERROR);
            return "register";
        }
        Role role = roleService.getByAuthority(Role.USER);
        user.setDateOfRegister(new Date());
        userService.persist(user);

        user.getRoles().add(role);
        userService.merge(user);
        attributes.addFlashAttribute("message", "Zarejestrowano nowego u¿ytkownika! Mo¿esz siê teraz zalogowaæ.");

        return "redirect:/";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ModelAndView showUser(@PathVariable(value = "userId") Long userId,
            HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        User user = userService.getById(userId);
        List<Post> posts = postService.getPostsByUser(user);
        boolean isAdmin = user.getRoles().stream().anyMatch((Role role) -> (role.getAuthority().equals(Role.USER)));

        model.addObject("user", user);
        if (user.isEnabled()) {
            model.addObject("status", "Aktywne");
        } else {
            model.addObject("status", "Nieaktywne");
        }
        if (isAdmin) {
            model.addObject("userRole", "Admin");
        } else {
            model.addObject("userRole", "U¿ytkownik");
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
        if (!user.getImageName().equals(User.DEFAULT_IMAGE_NAME)) {
            try {
                ImageService.deleteAvatar(user, session.getServletContext().getRealPath(Constants.UPLOAD_PATH));
                attributes.addFlashAttribute("success", Constants.DELETE_AVATAR_SUCCESS);
            } catch (ImageOperationException e) {
                attributes.addFlashAttribute("error", Constants.DELETE_AVATAR_ERROR);
            }
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
        String uploadPath = session.getServletContext().getRealPath(Constants.UPLOAD_PATH);
        model.setViewName("changeAvatar");
        try {
            ImageService.updateAvatar(image, userService.getById(userId), uploadPath);
            attributes.addFlashAttribute("success", "Pomyœlnie zmieniono awatar!");
            model.setViewName("redirect:/user/" + userId);
        } catch (ImageOperationException e) {
            model.addObject("error", e.getMessage());
            model.setViewName("changeAvatar");
        }
        return model;
    }

}

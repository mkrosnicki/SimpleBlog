package maku.mvc.controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import maku.mvc.config.ImageHandler;
import maku.mvc.config.ImageUploadException;
import maku.mvc.dao.CommentDao;
import maku.mvc.dao.UserDao;
import maku.mvc.entities.Post;
import maku.mvc.dao.PostDao;
import maku.mvc.entities.Comment;
import maku.mvc.entities.Role;
import maku.mvc.entities.User;
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

    @Autowired
    CommentDao commentDao;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        ModelAndView model = new ModelAndView();
        List<User> users = userDao.getAll();
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
        if (userDao.getUserByName(user.getName()) != null) {
            model.addAttribute("registerError", "Taki użytkownik już istnieje!");
            return "register";
        }
        if (!user.getPassword().equals(user.getRepeatPassword())) {
            model.addAttribute("registerError", "Wpisane hasła nie są takie same!");
            return "register";
        }
        if (!image.isEmpty()) {
            if (!ImageHandler.validate(image)) {
                model.addAttribute("registerError", "Akceptowany jedynie format JPG!");
                return "register";
            }
        }

        Role role = userDao.getRoleByAuthority("ROLE_USER");
        user.setEnabled(true);
        user.setImageName("user_default.jpg");
        userDao.addUser(user);
        user.getRoles().add(role);
        userDao.saveUser(user);

        String webResourcePath = session.getServletContext().getRealPath("/resources/upload/");
        if (!image.isEmpty()) {
            try {
                ImageHandler.save("user" + user.getId() + ".jpg", webResourcePath, image);
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
        List<Comment> comments = commentDao.getCommentsByUser(user);
        model.addObject("numberOfPosts", posts.size());
        model.addObject("numberOfComments", comments.size());
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
        String uploadPath = session.getServletContext().getRealPath("/resources/upload/");
        model.setViewName("changeAvatar");
        if (image.isEmpty()) {
            model.addObject("error", "Nie wybrano żadnego obrazka!");
            return model;
        }
        if (!ImageHandler.validate(image)) {
            model.addObject("error", "Akceptowany jedynie format JPG!");
            return model;
        }
        User user = userDao.getUserById(userId);
        model.setViewName("redirect:/user/" + userId);
        if (!user.getImageName().equals("user_default.jpg")) {
            if (!ImageHandler.delete(user.getImageName(), uploadPath)) {
                attributes.addFlashAttribute("error", "Nie udało się usunąć starego awatara!");
            }
        }
        try {
            ImageHandler.save("user" + user.getId() + ".jpg", uploadPath, image);
            user.setImageName("user" + user.getId() + ".jpg");
            userDao.saveUser(user);
        } catch (ImageUploadException ex) {
            attributes.addFlashAttribute("error", ex.getMessage());
        }
        attributes.addFlashAttribute("success", "Pomyślnie zmieniono awatar!");
        return model;
    }

}

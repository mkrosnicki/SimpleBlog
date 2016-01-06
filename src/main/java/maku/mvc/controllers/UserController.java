package maku.mvc.controllers;

import java.util.List;
import java.util.function.Predicate;
import javax.validation.Valid;
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
    public String registerUserForm(@Valid User user, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "register";
        }
        if (userDao.getUserByName(user.getName()) != null) {
            model.addAttribute("message", "Taki użytkownik już istnieje!");
            return "register";
        }
        Role role = userDao.getRoleByAuthority("ROLE_USER");
        user.setEnabled(true);
        userDao.addUser(user);
        user.getRoles().add(role);
        userDao.saveUser(user);
        attributes.addFlashAttribute("message", "Zarejestrowano nowego użytkownika! Możesz się teraz zalogować.");
        return "redirect:/register";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ModelAndView showUser(@PathVariable(value = "userId") Long userId) {
        ModelAndView model = new ModelAndView();
        User user = userDao.getUserById(userId);
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

}

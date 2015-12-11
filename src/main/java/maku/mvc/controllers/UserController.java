package maku.mvc.controllers;


import javax.validation.Valid;
import maku.mvc.dao.UserDao;
import maku.mvc.domain.Role;
import maku.mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    
    @Autowired
    UserDao dao;
    
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
        if (dao.getUserByName(user.getName()) != null) {
            model.addAttribute("message", "Taki użytkownik już istnieje!");
            return "register";
        }
        Role role = dao.getRoleByAuthority("ROLE_USER");
        user.setEnabled(true);
        dao.addUser(user);
        user.getRoles().add(role);
        dao.saveUser(user);
        attributes.addFlashAttribute("message", "Zarejestrowano nowego użytkownika! Możesz się teraz zalogować.");
        return "redirect:/register";    
    }
    
}

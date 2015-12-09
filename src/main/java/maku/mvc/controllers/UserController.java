package maku.mvc.controllers;

import java.util.Map;
import javax.validation.Valid;
import maku.mvc.dao.UserDaoImpl;
import maku.mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    @Autowired
    UserDaoImpl dao;
    
    @RequestMapping("/users")
    public String getPersonList(Map<String, Object> model) {
        model.put("persons", dao.getAll());
        return "list";
    }
    
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String addNewPerson(Model model) {
        model.addAttribute(new User());
        return "addedituser";
    }
    
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String validNewPerson(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "addedituser";
        dao.addUser(user);
        return "redirect:/users";
    }
    
    @RequestMapping(value = "/deleteuser/{userId}")
    public String deletePerson(@PathVariable("userId") Long id) {
        dao.deletePerson(null);
        return "redirect:/users";
    }
    
    @RequestMapping(value = "editperson/{userId}", method = RequestMethod.GET)
    public String editPersonPage(@PathVariable("userId") Long id, Model model) {
        model.addAttribute("person", dao.getUserByName(null));
        return "addedituser";
    }
    
}

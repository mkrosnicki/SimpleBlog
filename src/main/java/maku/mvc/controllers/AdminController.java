package maku.mvc.controllers;

import maku.mvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
@Secured(value = "ROLE_ADMIN")
public class AdminController {
    
    @Autowired
    UserDao dao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showAdminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("welcome", "Witaj adminie!");
        model.setViewName("admin");
        return model;
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        ModelAndView model = new ModelAndView();
        model.addObject("users", dao.getAll());
        model.setViewName("users");
        return model;
    }

}

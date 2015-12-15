package maku.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import maku.mvc.domain.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    PostDao postDao;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showHomePage(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.addObject("isAdminLogged", request.isUserInRole("ROLE_ADMIN"));
        model.addObject("posts", postDao.getAllPosts());
        model.setViewName("common");
        return model;
    }

    @RequestMapping(value = "/login")
    public String showLoginPage(Model model,
            @RequestParam(value = "error", required = false) String error) {
        
        if (error != null) {
            model.addAttribute("error", "Niepoprawne dane użytkownika!");
        } else {
            model.addAttribute("loginsuccess", "Zostałeś poprawnie zalogowany!");
        }
        return "login";
    }

}

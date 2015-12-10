package maku.mvc.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String showHomePage(Map<String, Object> model) {
        return "common";
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
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView showAdminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("welcome", "Witaj adminie!");
        model.setViewName("admin");
        return model;
    }

}

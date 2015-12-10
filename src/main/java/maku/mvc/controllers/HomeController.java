package maku.mvc.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String showHomePage(Map<String, Object> model) {
        return "common";
    }

    @RequestMapping(value = "/login")
    public String showLoginPage(Map<String, Object> model) {
        return "login";
    }

}

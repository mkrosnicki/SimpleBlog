package maku.mvc.controllers;

import java.util.Collections;
import java.util.List;
import maku.mvc.entities.Post;
import maku.mvc.dao.PostDao;
import maku.mvc.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showHomePage(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        List<Post> posts = postService.getSortedByDate();
        Collections.reverse(posts);
        model.addObject("posts", posts);
        if (error != null) {
            model.addObject("error", "Niepoprawne dane uzytkownika!");
        }
        model.setViewName("common");
        return model;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String showErrorPage() {
        return "403";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String showContact() {
        return "contact";
    }

}
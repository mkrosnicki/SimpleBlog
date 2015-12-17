package maku.mvc.controllers;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import maku.mvc.dao.UserDao;
import maku.mvc.domain.Post;
import maku.mvc.domain.PostDao;
import maku.mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
@Secured(value = "ROLE_ADMIN")
public class AdminController {
    
    @Autowired
    UserDao dao;
    
    @Autowired
    PostDao postDao;

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
    
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView showPosts() {
        ModelAndView model = new ModelAndView();
        model.addObject("posts", postDao.getAllPosts());
        model.setViewName("posts");
        return model;
    }
    
    @RequestMapping(value = "/addpost", method = RequestMethod.GET)
    public ModelAndView addPost() {
        ModelAndView model = new ModelAndView();
        model.addObject("post", new Post());
        model.setViewName("addpost");
        return model;
    }
    
    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public ModelAndView addPostForm(@Valid Post post, HttpServletRequest request) {
        User loggedUser = dao.getUserByName(request.getUserPrincipal().getName());
        post.setPoster(loggedUser);
        post.setDateOfPublish(new Date());
        postDao.persistPost(post);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/");
        return model;
    }
    
    @RequestMapping(value = "/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        postDao.removePost(id);
        return "redirect:/admin/posts";
    }

}

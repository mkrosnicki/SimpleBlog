/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.controllers;

import maku.mvc.domain.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
    
    @Autowired
    PostDao postDao;
    
    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
    public ModelAndView showPost(@PathVariable(value = "postId") Long postId) {
        ModelAndView model = new ModelAndView();
        model.addObject("post", postDao.getPostById(postId));
        model.setViewName("post");
        return model;
    }
    
}

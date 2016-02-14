/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.controllers;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import maku.mvc.dao.CommentDao;
import maku.mvc.dao.UserDao;
import maku.mvc.entities.Comment;
import maku.mvc.entities.Post;
import maku.mvc.dao.PostDao;
import maku.mvc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

    @Autowired
    PostDao postDao;

    @Autowired
    UserDao userDao;
    
    @Autowired
    CommentDao commentDao;

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
    public ModelAndView showPost(@PathVariable(value = "postId") Long postId) {
        ModelAndView model = new ModelAndView();
        Post post = postDao.getPostById(postId);
        model.addObject("post", post);
        // duplikujace sie obiekty - zamienić na Set? 
        //List<Comment> comments = post.getComments(); 
        model.addObject("comments", commentDao.getCommentsByPost(post));
        model.addObject("comment", new Comment());
        model.setViewName("post");
        return model;
    }

    @RequestMapping(value = "post/{postId}", method = RequestMethod.POST)
    public ModelAndView addCommentToPost(@PathVariable(value = "postId") Long postId, @Valid Comment comment, BindingResult result, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("post");
        if (result.hasErrors()) {
            return model;
        }
        Date date = new Date();
        Post post = postDao.getPostById(postId);
        String publisherName = request.getUserPrincipal().getName();
        User publisher = userDao.getUserByName(publisherName);
        comment.setPost(post);
        comment.setPublisher(publisher);
        comment.setDateOfPublish(date);
        //postDao.persistComment(comment);
        commentDao.mergeComment(comment);
        model.setViewName("redirect:/post/" + postId);
        return model;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.services;

import java.util.List;
import maku.mvc.dao.CommentDao;
import maku.mvc.entities.Comment;
import maku.mvc.entities.Post;
import maku.mvc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maku
 */
@Service
@Transactional
public class CommentService {

    @Autowired
    CommentDao commentDao;

    public void persistComment(Comment comment) {
        commentDao.persistComment(comment);
    }

    public void mergeComment(Comment comment) {
        commentDao.mergeComment(comment);
    }

    public Comment getCommentById(Long id) {
        return commentDao.getCommentById(id);
    }

    public List<Comment> getCommentsByUser(User user) {
        return commentDao.getCommentsByUser(user);
    }

    public List<Comment> getCommentsByPost(Post post) {
        return commentDao.getCommentsByPost(post);
    }

    public void removeComment(Long id) {
        commentDao.removeComment(id);
    }

    public void removeComment(Comment comment) {
        commentDao.removeComment(comment);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.dao;

import java.util.List;
import maku.mvc.entities.Comment;
import maku.mvc.entities.Post;
import maku.mvc.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CommentDao {

    public void persist(Comment comment);

    public void merge(Comment comment);

    public Comment getById(Long id);

    public List<Comment> getCommentsByUser(User user);

    public List<Comment> getCommentsByPost(Post post);

    public void remove(Long id);

    public void remove(Comment comment);

}

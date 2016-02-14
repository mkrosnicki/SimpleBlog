/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import maku.mvc.entities.Comment;
import maku.mvc.entities.Post;
import maku.mvc.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CommentDao {
    
    private final String COMMENTS_BY_USER = "SELECT c FROM Comment c WHERE c.user.id = :id";
    private final String COMMENTS_BY_POST = "SELECT c FROM Comment c WHERE c.post.id = :id";

    @PersistenceContext(name = "persistenceUnit", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public void persistComment(Comment comment) {
        em.persist(comment);
    }

    public void mergeComment(Comment comment) {
        em.merge(comment);
    }

    public Comment getCommentById(Long id) {
        return em.find(Comment.class, id);
    }

    public List<Comment> getCommentsByUser(User user) {
        return em.createQuery(COMMENTS_BY_USER).setParameter("id", user.getId()).getResultList();
    }

    public List<Comment> getCommentsByPost(Post post) {
        return em.createQuery(COMMENTS_BY_POST).setParameter("id", post.getId()).getResultList();
    }

    public void removeComment(Long id) {
        em.remove(getCommentById(id));
    }

    public void removeComment(Comment comment) {
        em.remove(comment);
    }

}

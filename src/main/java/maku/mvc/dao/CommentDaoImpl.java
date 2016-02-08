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
import javax.persistence.Query;
import maku.mvc.entities.Comment;
import maku.mvc.entities.Post;
import maku.mvc.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maku
 */

@Transactional
@Repository
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public void persist(Comment comment) {
        em.persist(comment);
    }

    @Override
    public void merge(Comment comment) {
        em.merge(comment);
    }

    @Override
    public Comment getById(Long id) {
        return em.find(Comment.class, id);
    }

    @Override
    public List<Comment> getCommentsByUser(User user) {
        Query query = em.createQuery("SELECT c FROM Comment c WHERE c.publisher.id = :id");
        query.setParameter("id", user.getId());
        return (List<Comment>) query.getResultList();
    }

    @Override
    public List<Comment> getCommentsByPost(Post post) {
        Query query = em.createQuery("SELECT c FROM Comment c WHERE c.post.id = :id");
        query.setParameter("id", post.getId());
        return (List<Comment>) query.getResultList();
    }

    @Override
    public void remove(Long id) {
        em.remove(getById(id));
    }

    @Override
    public void remove(Comment comment) {
        em.remove(comment);
    }

}

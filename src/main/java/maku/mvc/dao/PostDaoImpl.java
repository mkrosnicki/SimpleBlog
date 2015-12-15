package maku.mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import maku.mvc.domain.Comment;
import maku.mvc.domain.Post;
import maku.mvc.domain.PostDao;
import maku.mvc.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostDaoImpl implements PostDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Post> getAllPosts() {
        System.out.println("EntityManager" + em == null);
        return (List<Post>) em.createNamedQuery("Post.findAll").getResultList();
    }

    @Override
    public void persistPost(Post post) {
        em.persist(post);
    }

    @Override
    public void mergePost(Post post) {
        em.merge(post);
    }

    @Override
    public Post getPostById(Long id) {
        return (Post) em.createNamedQuery("Post.findById");
    }

    @Override
    public Post getPostByTitle(String title) {
        return (Post) em.createNamedQuery("Post.findByTitle");
    }

    @Override
    public List<Post> getByUser(User user) {
        return (List<Post>) em.createNamedQuery("SELECT p FROM Post p WHERE p.user.id = :user.id").getResultList();
    }

    @Override
    public void removePost(Post post) {
        em.remove(post);
    }

    @Override
    public void removePost(Long id) {
        em.remove(getPostById(id));
    }

    @Override
    public void persistComment(Comment comment) {
        em.persist(comment);
    }

    @Override
    public void mergeComment(Comment comment) {
        em.merge(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return (Comment) em.createNamedQuery("SELECT c FROM Comment c WHERE c.id = :id");
    }

    @Override
    public List<Comment> getCommentByUser(User user) {
        return (List<Comment>) em.createNamedQuery("SELECT c FROM Comment c WHERE c.user.id = :user.id");
    }

    @Override
    public void removeComment(Long id) {
        em.remove(getCommentById(id));
    }

    @Override
    public void removeComment(Comment comment) {
        em.remove(comment);
    }

}

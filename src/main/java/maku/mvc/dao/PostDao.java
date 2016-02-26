package maku.mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import maku.mvc.entities.Post;
import maku.mvc.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PostDao {

    private final String GET_ALL_POSTS = "SELECT p FROM Post p";
    private final String POST_BY_TITLE = "SELECT p FROM Post p WHERE p.title = :title";
    private final String POSTS_BY_USER = "SELECT p FROM Post p WHERE p.user.id = :id";
    private final String DELETE_ALL_POSTS = "DELETE FROM Post";

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public List<Post> getAll() {
        return (List<Post>) em.createQuery(GET_ALL_POSTS).getResultList();
    }

    public void persistPost(Post post) {
        em.persist(post);
    }

    public void mergePost(Post post) {
        em.merge(post);
    }

    public Post getPostById(Long id) {
        return em.find(Post.class, id);
    }

    public Post getPostByTitle(String title) {
        try {
            return em.createQuery(POST_BY_TITLE, Post.class).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Post> getPostsByUser(User user) {
        return em.createQuery(POSTS_BY_USER).setParameter("id", user.getId()).getResultList();
    }

    public void deletePost(Post post) {
        em.remove(post);
    }

    public void deletePost(Long id) {
        em.remove(getPostById(id));
    }

    public void deleteAll() {
        em.createQuery(DELETE_ALL_POSTS).executeUpdate();
    }

    public List<Post> findPostsWhichContains(String phrase) {
        return em.createQuery("SELECT p FROM Post p WHERE p.title LIKE :phrase OR p.text LIKE :phrase").setParameter("phrase","%" + phrase + "%").getResultList();
    };

}

package maku.mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import maku.mvc.entities.Post;
import maku.mvc.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PostDaoImpl implements PostDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public List<Post> getAllPosts() {
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
    public Post getById(Long id) {
        return (Post) em.find(Post.class, id);
    }

    @Override
    public Post getByTitle(String title) {
        return (Post) em.createNamedQuery("Post.findByTitle");
    }

    @Override
    public List<Post> getByUser(User user) {
        Query query = em.createQuery("SELECT p FROM Post p WHERE p.poster.id = :posterId");
        query.setParameter("posterId", user.getId());
        return query.getResultList();
    }

    @Override
    public void removePost(Post post) {
        em.remove(post);
    }

    @Override
    public void removePost(Long id) {
        em.remove(getById(id));
    }

}

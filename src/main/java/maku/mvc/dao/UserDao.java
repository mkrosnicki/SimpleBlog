package maku.mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import maku.mvc.entities.Role;
import maku.mvc.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDao {

    private final String GET_ALL_USERS = "SELECT u FROM User u";
    private final String USER_BY_NAME = "SELECT u FROM User u WHERE u.name = :name";
    private final String DELETE_ALL_USERS = "DELETE FROM User";

    @PersistenceContext(name = "persistenceUnit", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public List<User> getAll() {
        return (List<User>) em.createQuery(GET_ALL_USERS).getResultList();
    }

    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    public User getByName(String name) {
        try {
            return em.createQuery(USER_BY_NAME, User.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public void persist(User user) {
        em.persist(user);
    }

    public void merge(User user) {
        em.merge(user);
    }

    public void delete(User user) {
        em.remove(user);
    }

    public void deleteAll() {
        em.createQuery(DELETE_ALL_USERS).executeUpdate();
    }

}
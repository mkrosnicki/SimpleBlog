package maku.mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import maku.mvc.domain.Role;
import maku.mvc.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public List<User> getAll() {
        return (List<User>) em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public User getUserByName(String name) {
        User user;
        try {
            user = (User) em.createNamedQuery("User.findByName").setParameter("name", name).getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void saveUser(User user) {
        em.merge(user);
    }

    public void deletePerson(User person) {
        em.remove(getUserByName(person.getName()));
    }

    @Override
    public Role getRoleById(Long id) {
        return em.find(Role.class, id);
    }

    @Override
    public Role getRoleByAuthority(String authority) {
        return (Role) em.createNamedQuery("Role.findByAuthority").setParameter("authority", authority).getSingleResult();
    }
    
    @Override
    public List<Role> getRolesByAuthority(String authority) {
        return (List<Role>) em.createNamedQuery("Role.findByAuthority").setParameter("authority", authority).getResultList();
    }

    @Override
    public void addRole(Role role) {
        em.persist(role);
    }

    @Override
    public void saveRole(Role role) {
        em.merge(role);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(user);
    }

    @Override
    public User getUserById(Long id) {
        try {
            return (User) em.createNamedQuery("User.findById").setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
    }

}

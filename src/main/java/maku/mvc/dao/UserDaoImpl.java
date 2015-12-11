package maku.mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import maku.mvc.domain.Role;
import maku.mvc.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll() {
        return (List<User>) em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public User getUserByName(String name) {
        return em.find(User.class, name);
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
        return (Role) em.createNamedQuery("Role.findByAuthority");
    }
    
    public List<Role> getRolesByAuthority(String authority) {
        return (List<Role>) em.createNamedQuery("Role.findByAuthority").getResultList();
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

}

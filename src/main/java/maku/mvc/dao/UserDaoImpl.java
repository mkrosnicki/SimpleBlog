/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import maku.mvc.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDaoImpl {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<User> getAll() {
        return (List<User>) em.createNamedQuery("Person.findAll").getResultList();
    }
    
    public User getUserByName(String name) {
        return em.find(User.class, name);
    }
    
    public void addUser(User user) {
        em.persist(user);
    }
    
    public void saveUser(User user) {
        em.merge(user);
    }
    
    public void deletePerson(User person) {
        em.remove(getUserByName(person.getName()));
    }
    
}

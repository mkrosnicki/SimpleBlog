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
    
    public User getPersonById(Long id) {
        return em.find(User.class, id);
    }
    
    public void addPerson(User person) {
        em.persist(person);
    }
    
    public void savePerson(User person) {
        em.merge(person);
    }
    
    public void deletePerson(User person) {
        em.remove(getPersonById(person.getId()));
    }
    
    public void deletePerson(Long id) {
        em.remove(getPersonById(id));
    }
    
}

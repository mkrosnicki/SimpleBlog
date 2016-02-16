/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.services;

import java.util.List;
import maku.mvc.dao.UserDao;
import maku.mvc.entities.Role;
import maku.mvc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maku
 */
@Service
@Transactional
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getByName(String name) {
        return userDao.getByName(name);
    }

    public void persist(User user) {
        userDao.persist(user);
    }

    public void merge(User user) {
        userDao.merge(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public User getById(Long id) {
        return userDao.getUserById(id);
    }

}

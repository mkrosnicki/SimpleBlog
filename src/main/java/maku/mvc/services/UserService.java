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

    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public void persistUser(User user) {
        userDao.persist(user);
    }

    public void mergeUser(User user) {
        userDao.merge(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public Role getRoleById(Long id) {
        return userDao.getRoleById(id);
    }

    public Role getRoleByAuthority(String authority) {
        return userDao.getRoleByAuthority(authority);
    }

    public List<Role> getRolesByAuthority(String authority) {
        return userDao.getRolesByAuthority(authority);
    }

    public void persistRole(Role role) {
        userDao.persistRole(role);
    }

    public void mergeRole(Role role) {
        userDao.mergeRole(role);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.services;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import maku.mvc.constants.Constants;
import maku.mvc.dao.UserDao;
import maku.mvc.entities.Role;
import maku.mvc.entities.User;
import maku.mvc.exceptions.UserNotValidException;
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
    
    @Autowired
    RoleService roleService;

    public List<User> getAll() {
        return userDao.getAll();
    }

    public List<User> getSortedByName() {
        List<User> users = getAll();
        Collections.sort(users,
                (User u1, User u2) -> {
                    return u1.getName().compareTo(u2.getName());
                }
        );
        return users;
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

    public boolean isUserValidForRegister(User user) throws UserNotValidException {
        if (getByName(user.getName()) != null) {
            throw new UserNotValidException(Constants.USER_EXISTS_ERROR);
        }
        if (!user.getPassword().equals(user.getRepeatPassword())) {
            throw new UserNotValidException(Constants.PASSWORDS_DONT_MATCH_ERROR);
        }
        return true;
    }

    public void registerUser(User user) {
        Role role = roleService.getByAuthority(Role.USER);
        user.setDateOfRegister(new Date());
        persist(user);
        user.getRoles().add(role);
        merge(user);
    }

}

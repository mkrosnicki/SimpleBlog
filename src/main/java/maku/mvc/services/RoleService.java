/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.services;

import maku.mvc.dao.RoleDao;
import maku.mvc.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maku
 */
@Service
@Transactional
public class RoleService {
    
    @Autowired
    RoleDao roleDao;
    
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    public Role getByAuthority(String authority) {
        return roleDao.getByAuthority(authority);
    }

    public void persist(Role role) {
        roleDao.persist(role);
    }

    public void merge(Role role) {
        roleDao.merge(role);
    }

}

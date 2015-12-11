/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.dao;

import maku.mvc.domain.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface RoleDao {
    
    public Role getRoleById(Long id);
    
    public Role getRoleByAuthority(String authority);
    
    public void addRole(Role role);
    
}

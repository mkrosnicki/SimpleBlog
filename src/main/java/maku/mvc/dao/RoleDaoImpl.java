package maku.mvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import maku.mvc.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Role getRoleById(Long id) {
        return em.find(Role.class, id);
    }

    @Override
    public Role getRoleByAuthority(String authority) {
        return (Role) em.createNamedQuery("Role.findByAuthority");
    }

    @Override
    public void addRole(Role role) {
        em.persist(role);
    }

    @Override
    public void saveRole(Role role) {
        em.merge(role);
    }
    
}

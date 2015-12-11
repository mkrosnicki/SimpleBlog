package maku.mvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import maku.mvc.domain.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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

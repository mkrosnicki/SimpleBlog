package maku.mvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import maku.mvc.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDao {

    private final String ROLE_BY_AUTHORITY = "SELECT r FROM Role r WHERE r.authority = :authority";
    private final String DELETE_ALL_ROLES = "DELETE FROM Role";

    @PersistenceContext(name = "persistenceUnit", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public Role getById(Long id) {
        return em.find(Role.class, id);
    }

    public Role getByAuthority(String authority) {
        try {
            return em.createQuery(ROLE_BY_AUTHORITY, Role.class).setParameter("authority", authority).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public void persist(Role role) {
        em.persist(role);
    }

    public void merge(Role role) {
        em.merge(role);
    }

    public void deleteAll() {
        em.createQuery(DELETE_ALL_ROLES).executeUpdate();
    }

}
package chetenov.web.dao;

import chetenov.web.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

   @PersistenceContext
    EntityManager em;

    @Override
    public List<Role>getAllRoles(){
        System.out.println("getAllRoles()");
        List<Role> roles = em.createQuery("select r from Role r", Role.class).getResultList();
        System.out.println("done");
        return roles;
    }

    @Override
    public void saveRole(Role role) {
        System.out.println("saveRole()" + role);
        em.merge(role);
        System.out.println("done");
    }

    @Override
    public Role getRole(Long id) {
        System.out.println("getRole() " + id);
        return em.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String name) {
        System.out.println("getRoleByName() " + name);
        TypedQuery<Role> tq = em.createQuery("select r from Role as r where r.role=:param", Role.class);
        return tq.setParameter("param", name).getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void deleteRole(Long id) {
        Role role = em.getReference(Role.class, id);
        em.remove(role);
    }


}

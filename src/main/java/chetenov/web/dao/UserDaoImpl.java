package chetenov.web.dao;

import chetenov.web.model.Role;
import chetenov.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {

    }

        @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class)
//        return em.createQuery("select u from User u join fetch u.roles", User.class)
                .getResultList();
    }

    public List<Role>getAllRoles(){
        return em.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
//        for(Role r : user.getRoles()){
//            Long id = em.createQuery("select r from Role r where r.role=:param", Role.class)
//                    .setParameter("param", r.getRole()).getSingleResult().getId();
//            r.setId(id);
//        }
        em.merge(user);
    }

    @Override
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        User user = em.getReference(User.class, id);
        em.remove(user);
    }

    @Override
    public User getUserByName(String name) {
            TypedQuery<User> tq = em.createQuery("select u from User as u WHERE u.username=:param", User.class);
            return tq.setParameter("param", name).getSingleResult();
    }
}
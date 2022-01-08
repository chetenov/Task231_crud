package chetenov.web.dao;

import chetenov.web.model.Role;
import chetenov.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }
        @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        System.out.println("getAllUsers()");
        List<User> users = em.createQuery("select distinct u from User u join fetch u.roles", User.class).getResultList();
        System.out.println("done: ");
        return users;
    }

    @Override
    public void saveUser(User user) {
        System.out.println("saveUser() " + user);
        em.merge(user);
        System.out.println("done");
    }

    @Override
    public User getUser(Long id) {
        System.out.println("getUser() " + id);
        TypedQuery<User> tq = em.createQuery("select distinct u from User as u join fetch u.roles WHERE u.id=:param", User.class);
        User user = tq.setParameter("param", id).getSingleResult();

        System.out.println("done ");
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        User user = em.getReference(User.class, id);
        em.remove(user);
    }

    @Override
    public User getUserByName(String name) {
        System.out.println("getUserByName() " + name);
            TypedQuery<User> tq = em.createQuery("select distinct u from User as u join fetch u.roles WHERE u.username=:param", User.class);
            User user = tq.setParameter("param", name).getSingleResult();
//        System.out.println("done " + user);
            return user;
    }

}
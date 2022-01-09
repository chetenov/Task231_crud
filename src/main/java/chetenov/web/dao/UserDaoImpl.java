package chetenov.web.dao;

import chetenov.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        List<User> users = em.createQuery("select distinct u from User u left join fetch u.roles", User.class).getResultList();
        return users;
    }

    @Override
    public void saveUser(User user) {
        em.merge(user);
    }

    @Override
    public User getUser(Long id) {
        TypedQuery<User> tq = em.createQuery("select distinct u from User u left join fetch u.roles WHERE u.id=:param", User.class);
        User user = tq.setParameter("param", id).getSingleResult();
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        User user = em.getReference(User.class, id);
        em.remove(user);
    }

    @Override
    public User getUserByName(String name) {
        TypedQuery<User> tq = em.createQuery("select distinct u from User u left join fetch u.roles WHERE u.username=:param", User.class);
        User user = tq.setParameter("param", name).getSingleResult();
        return user;
    }

}
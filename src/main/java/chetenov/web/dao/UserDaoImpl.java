package chetenov.web.dao;

import chetenov.web.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void saveUser(User user) {
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
}
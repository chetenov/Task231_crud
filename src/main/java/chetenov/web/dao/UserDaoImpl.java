package chetenov.web.dao;

import chetenov.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void createUser(User user) {
        entityManagerFactory.createEntityManager().persist(user);
    }

    @Override
    public User readUserById(Long id) {
        return entityManagerFactory.createEntityManager().find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManagerFactory.createEntityManager().merge(user);

    }

    @Override
    public void deleteUserById(Long id) {
        entityManagerFactory.createEntityManager().remove(id);
    }

    @Override
    public List<User> findAllUsers() {
        return entityManagerFactory.createEntityManager().createQuery("select u from User u").getResultList();
    }
}

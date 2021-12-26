package chetenov.web.dao;

import chetenov.web.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        System.out.println("Подключаем e-m-factory");
    }


    @Override
    public List<User> getAllUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();

        List<User> allUsers = em.createQuery("from User", User.class)
                .getResultList();
        System.out.println("Получаем список allUsers");
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

    }

    @Override
    public User getUser(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = em.getReference(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
    }
}

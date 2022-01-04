package chetenov.web.dao;

import chetenov.web.model.Role;
import chetenov.web.model.User;
import chetenov.web.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl_SessionFactory implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl_SessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User>users = session.createQuery("select u from User u", User.class).getResultList();
        System.out.println("getAllUsers(): " + users);
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("Begin transaction with user " + user.getUsername());
        session.merge(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("End transaction with user " + user.getUsername());
    }

    @Override
    public User getUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        System.out.println("--------------------------------------");
        System.out.println("getUser: " + user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.getReference(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User getUserByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> tq = session.createQuery("select u from User as u WHERE u.username=:param", User.class);
        session.beginTransaction();
        User user = tq.setParameter("param", name).getSingleResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<Role> getAllRoles() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Role>roles = session.createQuery("select r from Role r", Role.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return roles;
    }
}

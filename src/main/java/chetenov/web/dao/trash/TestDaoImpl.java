package chetenov.web.dao.trash;

import chetenov.web.model.trash.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDaoImpl implements TestDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public <T>void save(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Test> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Test>testList = session.createQuery("select t from Test t", Test.class).getResultList();
        session.getTransaction().commit();
        return testList;
    }
}

package chetenov.web.dao;

import chetenov.web.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import java.util.List;

@Repository
public class EntityDaoImpl implements EntityDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public <T> void save(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("Begin transaction with " + t.toString());
        session.merge(t);
        session.getTransaction().commit();
        session.close();
        System.out.println("End transaction with " + t.toString());
    }

    @Override
    public <T> List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cr = (CriteriaQuery<T>) cb.createQuery(Object.class);
        Root<T> root = (Root<T>) cr.from(Object.class);
        cr.select(root);
        Query<T> query = session.createQuery(cr);
        List<T> results = query.getResultList();
        return results;
    }

    @Override
    public <T> T findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        T t = (T) session.get(Object.class, id);
        System.out.println("--------------------------------------");
        System.out.println("findById: " + t);
        session.getTransaction().commit();
        session.close();
        return t;
    }
}

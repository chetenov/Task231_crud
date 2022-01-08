package chetenov.web.dao.trash;

//import javax.persistence.Query;


//@Repository
public class EntityDaoImpl implements EntityDao{
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public <T> void save(T t) {
//        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        System.out.println("Begin transaction with " + t.toString());
//        session.merge(t);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("End transaction with " + t.toString());
//    }

//    @Override
//    public <T> List<T> findAll() {
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<T> cr = (CriteriaQuery<T>) cb.createQuery(Object.class);
//        Root<T> root = (Root<T>) cr.from(Object.class);
//        cr.select(root);
//        Query<T> query = session.createQuery(cr);
//        List<T> results = query.getResultList();
//        return results;
//    }
//
//    @Override
//    public <T> T findById(Long id) {
//        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        T t = (T) session.get(Object.class, id);
//        System.out.println("--------------------------------------");
//        System.out.println("findById: " + t);
//        session.getTransaction().commit();
//        session.close();
//        return t;
//    }
}

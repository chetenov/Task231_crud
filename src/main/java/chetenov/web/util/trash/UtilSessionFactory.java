package chetenov.web.util.trash;

import chetenov.web.model.Role;
import chetenov.web.model.trash.Test;
import chetenov.web.model.trash.TestRole;
import chetenov.web.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//@Service
public class UtilSessionFactory {
//
//    private static final String URL = "jdbc:mysql://localhost:3306/crud231?useSSL=false";
//    private static final String USER = "root";
//    private static final String PASSWORD = "939267";
//    private SessionFactory sessionFactory = null;
//
//    public UtilSessionFactory() {
//    }
//
//
////    @Bean(name = "sessionFactory")
//    public SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            Configuration configuration = new Configuration();
//            Properties settings = new Properties();
//            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//            settings.put(Environment.URL, URL);
//            settings.put(Environment.USER, USER);
//            settings.put(Environment.PASS, PASSWORD);
//            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//            settings.put(Environment.SHOW_SQL, "false");
//            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//            settings.put("hibernate.hbm2ddl.auto", "create-drop");
//            configuration.setProperties(settings);
//            configuration.addAnnotatedClass(Role.class);
//            configuration.addAnnotatedClass(User.class);
//            configuration.addAnnotatedClass(Test.class);
//            configuration.addAnnotatedClass(TestRole.class);
//
//            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration.getProperties())
//                    .build();
//
//            try {
//                sessionFactory = configuration.buildSessionFactory(registry);
//            } catch (Exception e) {
//                e.printStackTrace();
//                StandardServiceRegistryBuilder.destroy(registry);
//            }
//        }
//        return sessionFactory;
//    }
//
//    public Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
}

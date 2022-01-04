package chetenov.web.util;

import chetenov.web.dao.TestDao;
import chetenov.web.dao.TestDaoImpl;
import chetenov.web.model.*;
import chetenov.web.service.EntityService;
import chetenov.web.service.TestService;
import chetenov.web.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class Util {
    @Autowired
    private UserService userService;
    @Autowired
    private TestService testService;
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private EntityService entityService;

    private final Map<StandartRoles, Role> defaultRoles = new HashMap<>();


    @Bean
    public Map<StandartRoles, Role> getDefaultRoles() {
        Role role_admin = new Role(1L, "ROLE_ADMIN");
        Role role_user = new Role(2L, "ROLE_USER");
        defaultRoles.put(StandartRoles.ROLE_ADMIN, role_admin);
        defaultRoles.put(StandartRoles.ROLE_USER, role_user);
        System.out.println("Созданы объекты roles getDefaultRoles()");
        return defaultRoles;
    }


    public void fillDataBase() {

        System.out.println("--------------------U T I L---------------------");

        User user1 = new User("Administrator", "a", "a");
        User user2 = new User("Ivan", "ivan", "ivan");
        User user3 = new User("Maria", "maria", "maria");
        User user4 = new User("Petr", "petr", "petr");

        System.out.println("Созданы объекты users");


        entityService.save(defaultRoles.get(StandartRoles.ROLE_ADMIN));
        entityService.save(defaultRoles.get(StandartRoles.ROLE_USER));

        user1.addRoleToUser(defaultRoles.get(StandartRoles.ROLE_ADMIN));
        user1.addRoleToUser(defaultRoles.get(StandartRoles.ROLE_USER));
        user2.addRoleToUser(defaultRoles.get(StandartRoles.ROLE_USER));
        user3.addRoleToUser(defaultRoles.get(StandartRoles.ROLE_USER));
        user4.addRoleToUser(defaultRoles.get(StandartRoles.ROLE_USER));
//        user4.addRoleToUser(defaultRoles.get(StandartRoles.ROLE_ADMIN));

        System.out.println("Добавлены роли в объекты");


        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);

        System.out.println("--------------------END of UTIL-------------------");
    }

    public enum StandartRoles{
        ROLE_USER, ROLE_ADMIN
    }

}


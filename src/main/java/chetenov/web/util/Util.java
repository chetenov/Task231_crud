package chetenov.web.util;

import chetenov.web.model.*;
import chetenov.web.service.RoleService;
import chetenov.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.NonUniqueResultException;
import java.util.List;

@Service
public class Util {

//    public enum StandartRoles{
//        ROLE_USER, ROLE_ADMIN
//    }

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public Util(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


//    @Bean
//    public Map<StandartRoles, Role> getDefaultRoles() {
//        Role role_admin = new Role(1L, "ROLE_ADMIN");
//        Role role_user = new Role(2L, "ROLE_USER");
//        defaultRoles.put(StandartRoles.ROLE_ADMIN, role_admin);
//        defaultRoles.put(StandartRoles.ROLE_USER, role_user);
////        System.out.println("Созданы объекты roles getDefaultRoles()");
//        return defaultRoles;
//    }

//    @Bean
//    public void createRoles(){
//
//
//    }


    public void fillDataBase() {
        System.out.println("UTIL start");



        List<Role> roleList = null;
        try {
           roleList = roleService.getAllRoles();
        }catch (Exception e){
            System.out.println(roleList);
            System.out.println(e);
        }
        System.out.println("Была попытка получить роли: " + roleList);

        if (roleList == null || roleList.isEmpty()) {
            for (StandartRoles role : StandartRoles.values()) {
                roleService.saveRole(new Role(role));
            }
            System.out.println("Добавили роли...");
        }

        Role userRole = roleService.getRoleByName(StandartRoles.ROLE_USER.name());
        Role adminRole = roleService.getRoleByName(StandartRoles.ROLE_ADMIN.name());

//        User user = new User("Aaa", "a", passwordEncoder.encode("a"));
//        user.addRoleToUser(adminRole);
//        user.addRoleToUser(userRole);
//        userService.saveUser(user);

        userService.saveUsers(
                new User("Admin", "a", passwordEncoder.encode("a"),
                        "+79220005511", "aaa@mail.ru")
                .addRolesToUser(userRole, adminRole),

                new User("Ivan", "ivan", passwordEncoder.encode("ivan"),
                        "+79220005512", "ivan@mail.ru")
                .addRoleToUser(userRole),

                new User("Maria", "maria", passwordEncoder.encode("maria"),
                        "+79220005513", "maria@mail.ru")
                .addRoleToUser(userRole),

                new User("Petr", "petr", passwordEncoder.encode("petr"),
                        "+79220005514", "petr@mail.ru")
                .addRoleToUser(userRole));


//        User testUser = new User("Test", "test","test");
//        testUser.addRoleToUser(userRole);
//        System.out.println("RAW Password: " + testUser.getPassword());
//        String pass = passwordEncoder.encode(testUser.getPassword());
//        System.out.println("Encoded Password: " + pass);
//        testUser.setPassword(pass);
//        userService.saveUser(testUser);


        System.out.println("UTIL finish");

    }

}


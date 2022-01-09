package chetenov.web.util;

import chetenov.web.model.*;
import chetenov.web.service.RoleService;
import chetenov.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Util {


    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public Util(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public void fillDataBase() {
        System.out.println("UTIL start");


        List<Role> roleList = null;
        try {
            roleList = roleService.getAllRoles();
        } catch (Exception ignore) {
        }

        if (roleList == null || roleList.isEmpty()) {
            for (StandartRoles role : StandartRoles.values()) {
                roleService.saveRole(new Role(role));
            }
            System.out.println("Добавили роли...");
        }

        Role userRole = roleService.getRoleByName(StandartRoles.ROLE_USER.name());
        Role adminRole = roleService.getRoleByName(StandartRoles.ROLE_ADMIN.name());


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

        System.out.println("UTIL finish");

    }

}


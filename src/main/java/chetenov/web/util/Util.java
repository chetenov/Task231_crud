package chetenov.web.util;

import chetenov.web.model.Role;
import chetenov.web.model.User;
import chetenov.web.service.RoleService;
import chetenov.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Util {

    private final UserService userService;
    private final RoleService roleService;
    Set<Role> defaultRoles;

    @Autowired
    public Util(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void postConstruct(){
        System.out.println("==============START OF POST CONSTRUCT===============");
        addRolesToDB();
        addUsersToDB();
        System.out.println("--------------END OF POST CONSTRUCT----------------");
    }

    private void addRolesToDB(){

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
    }

    public void addUsersToDB(){

        Role roleUser = roleService.getRoleByName(StandartRoles.ROLE_USER.name());
        Role roleAdmin = roleService.getRoleByName(StandartRoles.ROLE_ADMIN.name());

        userService.saveUsers(
                new User("Admin", "a", "a",
                        "+79220005511", "aaa@mail.ru")
                        .addRolesToUser(roleUser, roleAdmin),

                new User("Ivan", "ivan", "ivan",
                        "+79220005512", "ivan@mail.ru")
                        .addRoleToUser(roleUser),

                new User("Maria", "maria", "maria",
                        "+79220005513", "maria@mail.ru")
                        .addRoleToUser(roleUser),

                new User("Petr", "petr", "petr",
                        "+79220005514", "petr@mail.ru")
                        .addRoleToUser(roleUser));

        System.out.println("Добавили стартовых юзеров");
    }

    @Bean
    public Set<Role> getDefaultRoles() {
        if (defaultRoles == null || defaultRoles.isEmpty()) {
            defaultRoles = new HashSet<>(roleService.getAllRoles());
        }
        return defaultRoles;
    }
}



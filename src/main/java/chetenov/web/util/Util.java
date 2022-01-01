package chetenov.web.util;

import chetenov.web.model.DefaultRoles;
import chetenov.web.model.Role;
import chetenov.web.model.User;
import chetenov.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Component
public class Util {
    private final UserService userService;

    @Autowired
    public Util(UserService userService) {
        this.userService = userService;
    }


    @Bean
    public void fillDataBase() {

        Role role_admin = new Role(1L, DefaultRoles.ROLE_ADMIN);
        Role role_user = new Role(2L, DefaultRoles.ROLE_USER);
        User user1 = new User("Administrator", "a", "a", new HashSet<>(Arrays.asList(role_admin, role_user)));
        User user2 = new User("Ivan", "ivan", "ivan", Collections.singleton(role_user));
        User user3 = new User("Maria", "maria", "maria", Collections.singleton(role_user));
        User user4 = new User("Petr", "petr", "petr", Collections.singleton(role_user));

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
    }
}

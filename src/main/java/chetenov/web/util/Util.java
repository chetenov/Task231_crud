package chetenov.web.util;

import chetenov.web.entity.User;
import chetenov.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Util {
    private final UserService userService;

    @Autowired
    public Util(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public void fillDataBase() {
        User user1 = new User("Иван", "Петров", "2323223", "petrov@mail.ru");
        User user2 = new User("Петр", "Сидоров", "4345565", "sidorov@mail.ru");
        User user3 = new User("John", "Travolta", "4345565", "travolta@gmail.com");
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
    }
}

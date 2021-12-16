package chetenov.web.service;



import chetenov.web.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void createUser(User user);
    User readUserById(Long id);
    void updateUser(User user);
    void deleteUserById(Long id);
    List<User> findAllUsers();
}

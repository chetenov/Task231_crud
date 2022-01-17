package chetenov.web.service;

import chetenov.web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user, Long id);

    void saveUsers(User ... user);

    User getUser(Long id);

    void deleteUser(Long id);
}

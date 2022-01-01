package chetenov.web.dao;

import chetenov.web.model.User;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    User getUserByName(String name);
}

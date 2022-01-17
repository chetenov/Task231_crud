package chetenov.web.dao;

import chetenov.web.model.User;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user, Long id);

    User getUser(Long id);

    void deleteUser(Long id);

    User getUserByName(String name);

}

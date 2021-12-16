package chetenov.web.dao;

import chetenov.web.entity.User;
import org.springframework.dao.support.DaoSupport;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    User readUserById(Long id);
    void updateUser(User user);
    void deleteUserById(Long id);
    List<User>findAllUsers();
}

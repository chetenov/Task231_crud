package chetenov.web.dao;

import chetenov.web.entity.User;
import org.springframework.dao.support.DaoSupport;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);
}

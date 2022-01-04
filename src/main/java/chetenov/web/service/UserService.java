package chetenov.web.service;



import chetenov.web.model.Role;
import chetenov.web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

//    void createTables();

    List<User> getAllUsers();

    public List<Role> getAllRoles();

    void saveUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);
}

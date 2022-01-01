package chetenov.web.service;

import chetenov.web.dao.UserDao;
import chetenov.web.model.DefaultRoles;
import chetenov.web.model.Role;
import chetenov.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        Set<String> rolesStr = user.getRolesInString();
        if (rolesStr != null){
            Set<Role> roles = new HashSet<>();
            for (String s : rolesStr){
                roles.add(new Role((long) DefaultRoles.valueOf(s).ordinal()+1, s));
            }
            user.setRoles(roles);
        }
        userDao.saveUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}

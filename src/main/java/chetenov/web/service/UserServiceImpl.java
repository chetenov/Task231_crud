package chetenov.web.service;

import chetenov.web.dao.UserDao;
import chetenov.web.model.Role;
import chetenov.web.model.User;
import chetenov.web.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class UserServiceImpl implements UserService{
    UserDao userDao;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl_SessionFactory") UserDao userDao) {
        this.userDao = userDao;

    }

//    public void createTables(){
//        userDao.createTables();
//    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<Role> getAllRoles() {
        return userDao.getAllRoles();
    }

    @Override
//    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
//    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}

package chetenov.web.service;

import chetenov.web.dao.UserDao;
import chetenov.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public User readUserById(Long id) {
        return userDao.readUserById(id);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}

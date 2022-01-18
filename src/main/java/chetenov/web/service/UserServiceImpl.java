package chetenov.web.service;

import chetenov.web.dao.UserDao;
import chetenov.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            userDao.saveUser(user);
        } catch (RuntimeException ignore) {
            throw new RuntimeException("Ошибка сохранения пользователя. Возможно, username '" + user.getUsername() +  "' занят :(");
        }
    }

    @Override
    @Transactional
    public void updateUser(User user, Long id) {
        User daouser = null;
        Long daouserId = -1L;

        try {
            daouser = userDao.getUserByUsername(user.getUsername());
            daouserId = daouser.getId();
        } catch (Exception ignore) {
        }

        if (daouser != null && daouserId != id) {
            throw new RuntimeException("Ошибка обновления пользователя. Кажется, username '" + user.getUsername() +  "' занят :(");
        }

        if (!user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            try {
                user.setPassword(getUser(user.getId()).getPassword());
            } catch (Exception ignore) {
            }
        }
        userDao.updateUser(user, id);
    }

    @Override
    @Transactional
    public void saveUsers(User... user) {
        Arrays.stream(user).forEach(this::saveUser);
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

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}

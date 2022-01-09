package chetenov.web.service;

import chetenov.web.dao.RoleDao;
import chetenov.web.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
            roleDao.saveRole(role);
    }

    @Override
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {

    }
}

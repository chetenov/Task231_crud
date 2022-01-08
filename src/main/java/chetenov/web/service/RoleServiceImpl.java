package chetenov.web.service;

import chetenov.web.dao.RoleDao;
import chetenov.web.exception.NotUniqRoleException;
import chetenov.web.exception.NotUniqUsernameException;
import chetenov.web.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
    @Override
    public void saveRole(Role role) throws RuntimeException{
//        if (getRoleByName(role.getRole()) == null) {
            roleDao.saveRole(role);
//        } else throw new NotUniqRoleException("Role already exists!");
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
    public void deleteRole(Long id) {

    }
}

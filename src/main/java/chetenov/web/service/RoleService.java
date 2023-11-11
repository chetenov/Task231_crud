package chetenov.web.service;

import chetenov.web.model.Role;
import chetenov.web.model.User;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    void saveRole(Role role);

    Role getRole(Long id);

    Role getRoleByName(String name);

    void deleteRole(Long id);
}

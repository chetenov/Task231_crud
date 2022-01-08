package chetenov.web.model.trash;

import chetenov.web.model.Role;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Wanna_Roles {
    private Set<Role>roleSet;
    private Role[] roles;

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    public Wanna_Roles() {
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}

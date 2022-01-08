package chetenov.web.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserForm implements Serializable {
    private Set<String> roles = new HashSet<>();
    private Set<String> activeRoles = new HashSet<>();
    private Set<String> checkAuthSet = new HashSet<>();
    private String newPassword;
    private boolean flag1;
    private boolean flag2;
    private boolean flag3;
    private boolean flag4;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public boolean isFlag1() {
        return flag1;
    }

    public void setFlag1(boolean flag1) {
        this.flag1 = flag1;
    }

    public boolean isFlag2() {
        return flag2;
    }

    public void setFlag2(boolean flag2) {
        this.flag2 = flag2;
    }

    public boolean isFlag3() {
        return flag3;
    }

    public void setFlag3(boolean flag3) {
        this.flag3 = flag3;
    }

    public boolean isFlag4() {
        return flag4;
    }

    public void setFlag4(boolean flag4) {
        this.flag4 = flag4;
    }

    public Set<String> getCheckAuthSet() {
        return checkAuthSet;
    }

    public void setCheckAuthSet(Set<String> checkAuthSet) {
        this.checkAuthSet = checkAuthSet;
    }

    private Map<String, Boolean> checkBoxes;

    public Map<String, Boolean> getCheckBoxes() {
        return checkBoxes;
    }

    public void setCheckBoxes(Map<String, Boolean> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    public Set<String> getActiveRoles() {
        return activeRoles;
    }

    public void setActiveRoles(Set<String> activeRoles) {
        this.activeRoles = activeRoles;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserForm() {
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}

package chetenov.web.model;

import chetenov.web.util.StandartRoles;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Этот класс реализует интерфейс GrantedAuthority, в котором необходимо переопределить только один метод getAuthority() (возвращает имя роли).
// Имя роли должно соответствовать шаблону: «ROLE_ИМЯ», например, ROLE_USER.


@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", unique = true)
    private String role;

    @ManyToMany
    @JoinTable(name = "users_roles"
            , joinColumns = @JoinColumn(name = "role_id")
            , inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    public Role() {
//        System.out.println("Вызван конструктор 0");
    }


//    public Role(String role) {
//        this.role = role;
////        System.out.println("Вызван конструктор 1");
//    }

    public Role(StandartRoles standartRole){
        this.role = standartRole.name();
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
//        System.out.println("Вызван конструктор 2");
    }

    public void addUserToRole(User user){
        users.add(user);
    }

    public void addUsersToRole(User ... user){
        users.addAll(Arrays.asList(user));
    }

    public Set<User> getUsers() {
        return users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}

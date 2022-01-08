package chetenov.web.model.trash;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "test_roles"
            , joinColumns = @JoinColumn(name = "test_id")
            , inverseJoinColumns = @JoinColumn(name = "testRole_id")
    )
    private Set<TestRole>testRoles = new HashSet<>();

    public Test() {
    }

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<TestRole> getTestRoles() {
        return testRoles;
    }

    public void setTestRoles(Set<TestRole> testRoles) {
        this.testRoles = testRoles;
    }

    public void addTestRole(TestRole testRole){
        testRoles.add(testRole);
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", testRoles=" + testRoles +
                '}';
    }
}

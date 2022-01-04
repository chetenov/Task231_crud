package chetenov.web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TestRole {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "test_roles"
            , joinColumns = @JoinColumn(name = "testRole_id")
            , inverseJoinColumns = @JoinColumn(name = "test_id")
    )
    private Set<Test>testItems = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public TestRole() {
    }

    public TestRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Test> getTestItems() {
        return testItems;
    }

    public void setTestItems(Set<Test> testItems) {
        this.testItems = testItems;
    }

    public void addTestItem(Test test){
        testItems.add(test);
    }

    @Override
    public String toString() {
        return "TestRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

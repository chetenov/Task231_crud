package chetenov.web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TestForms {
    private String name;
    private String legenda;
    private String textContainer;
    private Set<String>textContainerInSet;
    private Set<String>optionsSet;
    private List<String>optionsList;
    private int someNumber;
    private Set<Role> authorities;

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public TestForms() {

    }

    public String getTextContainer() {
        return textContainer;
    }

    public void setTextContainer(String textContainer) {
        this.textContainer = textContainer;
    }

    public Set<String> getTextContainerInSet() {
        return textContainerInSet;
    }

    public void setTextContainerInSet(Set<String> textContainerInSet) {
        this.textContainerInSet = textContainerInSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public Set<String> getOptionsSet() {
        return optionsSet;
    }

    public void setOptionsSet(Set<String> optionsSet) {
        this.optionsSet = optionsSet;
    }

    public List<String> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<String> optionsList) {
        this.optionsList = optionsList;
    }

    public int getSomeNumber() {
        return someNumber;
    }

    public void setSomeNumber(int someNumber) {
        this.someNumber = someNumber;
    }

    @Override
    public String toString() {
        return "TestForms{" +
                "name='" + name + '\'' +
                ", legenda='" + legenda + '\'' +
                ", textContainer='" + textContainer + '\'' +
                ", textContainerInSet=" + textContainerInSet +
                ", optionsSet=" + optionsSet +
                ", optionsList=" + optionsList +
                ", someNumber=" + someNumber +
                ", authorities=" + authorities +
                '}';
    }
}

package chetenov.web.dao;

import chetenov.web.model.Test;

import java.util.List;

public interface TestDao {

//    public void save(Test test);

    <T>void save(T t);

    public List<Test> getAll();
}

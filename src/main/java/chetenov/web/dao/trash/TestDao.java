package chetenov.web.dao.trash;

import chetenov.web.model.trash.Test;

import java.util.List;

public interface TestDao {

//    public void save(Test test);

    <T>void save(T t);

    public List<Test> getAll();
}

package chetenov.web.service.trash;

import chetenov.web.model.trash.Test;

import java.util.List;

public interface TestService {


    public <T>void save(T t);

    public List<Test> getAll();

}

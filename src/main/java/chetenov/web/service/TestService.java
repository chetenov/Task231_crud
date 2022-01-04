package chetenov.web.service;

import chetenov.web.model.Test;

import java.util.List;

public interface TestService {


    public <T>void save(T t);

    public List<Test> getAll();

}

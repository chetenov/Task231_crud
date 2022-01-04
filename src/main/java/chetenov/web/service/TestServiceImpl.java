package chetenov.web.service;

import chetenov.web.dao.TestDao;
import chetenov.web.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    TestDao testDao;

    @Override
    public <T>void save(T t) {
        testDao.save(t);
    }

    @Override
    public List<Test> getAll() {
        return testDao.getAll();
    }
}

package chetenov.web.service;

import chetenov.web.dao.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntyServiceImpl implements EntityService{

    @Autowired
    private EntityDao entityDao;

    @Override
    public <T> void save(T t) {
        entityDao.save(t);

    }

    @Override
    public <T> List<T> findAll() {
        return entityDao.findAll();
    }

    @Override
    public <T> T findById(Long id) {
        return entityDao.findById(id);
    }
}

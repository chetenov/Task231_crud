package chetenov.web.dao;

import java.util.List;

public interface EntityDao {
    <T>void save(T t);
    <T> List<T> findAll();
    <T> T findById(Long id);
}

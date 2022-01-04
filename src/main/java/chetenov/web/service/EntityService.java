package chetenov.web.service;

import java.util.List;

public interface EntityService {
    <T>void save(T t);
    <T>List<T> findAll();
    <T> T findById(Long id);
}

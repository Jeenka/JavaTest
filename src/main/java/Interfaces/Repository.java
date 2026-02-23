package Interfaces;

import java.util.List;

public interface Repository<T extends Identifiable<?>> {
    void save(T entity);
    T findById(Object id);
    List<T> findAll();
}

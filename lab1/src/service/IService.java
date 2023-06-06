package service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    public boolean create(T t);

    public boolean delete(String key);

    public boolean update(T t);

    public List<T> findAll();

    public Optional<T> find(String key);
}

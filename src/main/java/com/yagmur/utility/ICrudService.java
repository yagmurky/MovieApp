package com.yagmur.utility;

import com.yagmur.entity.User;

import java.util.List;
import java.util.Optional;

public interface ICrudService <T, ID>{

        T save(T entity);
        T update(T entity);
        Iterable<T> saveAll(Iterable<T> entities);
        List<T> findAll();
        Optional<T> findById(ID id);
        T deleteById(ID id);

}

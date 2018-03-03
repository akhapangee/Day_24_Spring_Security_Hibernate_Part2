package com.akhilesh.webapp.service;

import java.util.List;

/**
 *
 * @author Akhilesh
 */
public interface GenericService<T> {
     int insert(T t);
    void update(T t);
    boolean delete(int id);
    T getById(int id);
    List<T> getAll();
}

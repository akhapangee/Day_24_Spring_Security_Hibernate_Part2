package com.akhilesh.webapp.dao.impl;

import com.akhilesh.webapp.dao.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Akhilesh
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;
    protected Class<?> persistClass;

    public GenericDAOImpl() {
        persistClass = (Class<?>) ((ParameterizedType) getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public List<T> getAll() {
        session = sessionFactory.openSession();
        return session.createCriteria(persistClass).list();
    }
    

    @Override
    public int insert(T t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        return result;
    }

    @Override
    public void update(T t) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        trans.commit();
    }

    @Override
    public T getById(int id) {
        session = sessionFactory.openSession();
        return (T) session.get(persistClass, id);
    }

    @Override
    public boolean delete(int id) {
        session = sessionFactory.openSession();
        persistClass = (Class<?>) getById(id);
        if (persistClass != null) {
            trans = session.beginTransaction();
            session.delete(persistClass);
            trans.commit();
            return true;
        }
        return false;
    }

}

package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDao extends HibernateDaoSupport {

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public Long createUser(User user) {
        return (Long) getHibernateTemplate().save(user);
    }

    public User getUser(Long id) {
        return getHibernateTemplate().get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(User.class));
    }
    
}

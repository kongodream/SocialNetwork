package com.gamenet.dao;

import com.gamenet.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 06.01.16.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public User findByUserName(String username) {
        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("from User where username=?")
                .setParameter(0, username)
                .list();

        return users.size() > 0 ? users.get(0) : null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}

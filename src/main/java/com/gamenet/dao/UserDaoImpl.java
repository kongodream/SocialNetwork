package com.gamenet.dao;

import com.gamenet.domain.FriendInvite;
import com.gamenet.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 06.01.16.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public User getUserByName(String username) {
        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("from User where username=:username")
                .setString( "username", username )
                .list();

        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User getUserById(int id) {
        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("from User where id= :id")
                .setInteger("id", id)
                .list();
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public void createRequestToFriendship(User initiator, User user) {
        user.getRequestsFromPersons().add(new FriendInvite(initiator, user));
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}

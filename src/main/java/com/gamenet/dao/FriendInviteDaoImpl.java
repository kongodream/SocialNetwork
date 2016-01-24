package com.gamenet.dao;

import com.gamenet.domain.FriendInvite;
import com.gamenet.domain.FriendInvitePK;
import com.gamenet.domain.User;
import org.hibernate.SessionFactory;

/**
 * Created by ivan on 21.01.16.
 */
public class FriendInviteDaoImpl implements FriendInviteDao {

    private SessionFactory sessionFactory;

    @Override
    public void createNewInvite(User initiator, User user) {
        FriendInvitePK friendInvitePK = new FriendInvitePK(initiator.getId(), user.getId());

        FriendInvite friendInvite = new FriendInvite();
        friendInvite.setFriendInvitePK(friendInvitePK);
        friendInvite.setFromUser(initiator);
        friendInvite.setToUser(user);

        initiator.getRequestsFromPersons().add(friendInvite);

//        sessionFactory.getCurrentSession().saveOrUpdate(friendInvitePK);
        sessionFactory.getCurrentSession().saveOrUpdate(friendInvite);
        sessionFactory.getCurrentSession().saveOrUpdate(initiator);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

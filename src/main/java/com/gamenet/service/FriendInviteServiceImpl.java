package com.gamenet.service;

import com.gamenet.dao.FriendInviteDao;
import com.gamenet.dao.UserDao;
import com.gamenet.domain.FriendInvite;
import com.gamenet.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ivan on 21.01.16.
 */
@Service
public class FriendInviteServiceImpl implements FriendInviteService {

    @Autowired
    private FriendInviteDao friendInviteDao;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void requestForFriendship(User initiator, User user) {
//        System.out.println(initiator.getUsername()+  "  to "+ user.getUsername());
//        FriendInvite friendInvite = new FriendInvite(initiator, user);
//
//        friendInviteDao.createNewInvite(friendInvite);
        friendInviteDao.createNewInvite(initiator, user);
    }
}

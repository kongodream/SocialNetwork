package com.gamenet.service;

import com.gamenet.dao.FriendInviteDao;
import com.gamenet.dao.UserDao;
import com.gamenet.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ivan on 21.01.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private FriendInviteDao friendInviteDao;

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public User getUserByUserName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    @Transactional
    public User getCurrentUser() {
        UserDetails userDetails = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        return (this.getUserByUserName(userName));
    }
}

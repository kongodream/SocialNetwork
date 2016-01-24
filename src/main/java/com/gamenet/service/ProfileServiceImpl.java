package com.gamenet.service;

import com.gamenet.dao.UserDao;
import com.gamenet.domain.Profile;
import com.gamenet.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ivan on 20.01.16.
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Profile getProfile(int id) {
        User user = userDao.getUserById(id);
        return user.getProfile();
    }
}

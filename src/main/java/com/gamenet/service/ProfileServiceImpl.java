package com.gamenet.service;

import com.gamenet.dao.UserDao;
import com.gamenet.domain.Profile;
import com.gamenet.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by ivan on 20.01.16.
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserDao userDao;

    @Override
    public Profile getProfile(int id) {
        User user = userDao.findUserById(id);
        return user.getProfile();
    }
}

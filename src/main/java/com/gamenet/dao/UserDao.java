package com.gamenet.dao;

import com.gamenet.domain.User;

/**
 * Created by ivan on 06.01.16.
 */
public interface UserDao {
    public User findByUserName(String username);
}

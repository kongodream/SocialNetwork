package com.gamenet.service;


import com.gamenet.domain.User;

/**
 * Created by ivan on 21.01.16.
 */
public interface UserService {
    public User getUserById(int id);

    public User getUserByUserName(String username);

    public User getCurrentUser();
}

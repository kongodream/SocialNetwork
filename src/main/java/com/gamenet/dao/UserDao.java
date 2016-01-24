package com.gamenet.dao;

import com.gamenet.domain.User;

/**
 * Created by ivan on 06.01.16.
 */
public interface UserDao {
    public User getUserByName(String username);

    public User getUserById(int id);

    public void createRequestToFriendship(User currentUser, User user);

//    public void requestForFriendship(User user);

}

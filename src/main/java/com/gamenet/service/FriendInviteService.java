package com.gamenet.service;

import com.gamenet.domain.User;

/**
 * Created by ivan on 21.01.16.
 */
public interface FriendInviteService {
    public void requestForFriendship(User initiator, User user);
}

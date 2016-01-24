package com.gamenet.dao;

import com.gamenet.domain.FriendInvite;
import com.gamenet.domain.User;

/**
 * Created by ivan on 21.01.16.
 */
public interface FriendInviteDao {
    public void createNewInvite(User initiator, User user);

//    public void deleteRequest();
}

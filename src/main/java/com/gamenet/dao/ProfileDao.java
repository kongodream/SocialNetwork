package com.gamenet.dao;

import com.gamenet.domain.Profile;
import com.gamenet.domain.User;

/**
 * Created by ivan on 05.01.16.
 */
public interface ProfileDao {

    public Profile getProfileByPerson(User user);

}

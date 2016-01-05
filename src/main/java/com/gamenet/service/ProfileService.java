package com.gamenet.service;

import com.gamenet.domain.Person;
import com.gamenet.domain.Profile;

/**
 * Created by ivan on 05.01.16.
 */
public interface ProfileService {

    public Profile getProfile(Person person);

}

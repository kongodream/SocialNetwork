package com.gamenet.dao;

import com.gamenet.domain.Person;
import com.gamenet.domain.Profile;

/**
 * Created by ivan on 05.01.16.
 */
public interface ProfileDao {

    public Profile getProfileByPerson(Person person);

}

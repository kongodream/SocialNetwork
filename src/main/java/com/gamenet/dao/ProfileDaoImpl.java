package com.gamenet.dao;

import com.gamenet.domain.Person;
import com.gamenet.domain.Profile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan on 05.01.16.
 */
@Repository
public class ProfileDaoImpl implements ProfileDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Profile getProfileByPerson(Person person) {
        return person.getProfile();
    }
}

package com.gamenet.service;

import com.gamenet.dao.PersonDAO;
import com.gamenet.domain.Person;
import com.gamenet.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 04.01.16.
 */
@Service
public class PersonServiceImpl implements PersonService, ProfileService{

    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
    public List<Person> listPersons() {
        return personDAO.listPersons();
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }


    @Override
    public Profile getProfile(Person person) {
        return person.getProfile();
    }
}

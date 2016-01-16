package com.gamenet.dao;


import com.gamenet.domain.Person;

import java.util.List;

/**
 * Created by ivan on 04.01.16.
 */
public interface PersonDao {

    public List<Person> listPersons();

    public Person getPersonById(int id);

}

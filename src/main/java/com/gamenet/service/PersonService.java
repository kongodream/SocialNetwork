package com.gamenet.service;

import com.gamenet.domain.Data;
import com.gamenet.domain.Person;

import java.util.List;

/**
 * Created by ivan on 04.01.16.
 */
public interface PersonService {

    public List<Person> listPersons();

    public Person getPersonById(int id);

}

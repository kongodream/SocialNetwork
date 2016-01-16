package com.gamenet.dao;

import com.gamenet.domain.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ivan on 04.01.16.
 */
@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> listPersons() {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Person getPersonById(int personId) {
        Person person = sessionFactory.getCurrentSession().get(Person.class, personId);
        return person;
    }

}

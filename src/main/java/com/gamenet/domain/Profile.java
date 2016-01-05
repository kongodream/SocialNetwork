package com.gamenet.domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by ivan on 02.01.16.
 */
@Entity
@Table(name = "Profiles")
public class Profile {

    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="person"))
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private Date birthday;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;

    public Profile(String name, String surname, String sex) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    public Profile(String name, String surname, String sex, Date birthday) {
        this(name, surname, sex);
        this.birthday = birthday;
    }

    public Profile() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

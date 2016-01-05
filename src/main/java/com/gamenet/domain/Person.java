package com.gamenet.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;

/**
 * Created by ivan on 02.01.16.
 */
@Entity
@Table(name = "Persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String login;
    private String password;
    private String email;

    @OneToOne(mappedBy="person", cascade=CascadeType.ALL)
    private Profile profile;

    @OneToOne(mappedBy="person", cascade=CascadeType.ALL)
    private Data data;

    public Person(String login, String password, String email, Profile profile) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.profile = profile;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}

package com.gamenet.domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ivan on 02.01.16.
 */
@Entity
@Table(name = "Data")
public class Data {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="user"))
    private int id;

    @Column(name = "short_information")
    private String shortInformation;

    @Column(name = "films")
    private String films;

    @Column(name = "music")
    private String music;

    @Column(name = "books")
    private String books;

    @Column(name = "games")
    private String games;

    @Column(name = "favorite_persons")
    private String favoritePersons;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    public Data(String shortInformation, String films, String music, String books, String games, String favoritePersons) {
        this.shortInformation = shortInformation;
        this.films = films;
        this.music = music;
        this.books = books;
        this.games = games;
        this.favoritePersons = favoritePersons;
    }

    public Data() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortInformation() {
        return shortInformation;
    }

    public void setShortInformation(String shortInformation) {
        this.shortInformation = shortInformation;
    }

    public String getFilms() {
        return films;
    }

    public void setFilms(String films) {
        this.films = films;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public String getFavoritePersons() {
        return favoritePersons;
    }

    public void setFavoritePersons(String favoritePersons) {
        this.favoritePersons = favoritePersons;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

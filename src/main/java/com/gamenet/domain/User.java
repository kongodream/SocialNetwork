package com.gamenet.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 06.01.16.
 */
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRoles = new HashSet<>();


    @OneToOne(mappedBy="user", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Profile profile;

    @OneToOne(mappedBy="user", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Data data;

    @OneToMany(mappedBy = "fromUser", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<FriendInvite> personRequests;

    @OneToMany(mappedBy = "toUser", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<FriendInvite> requestsFromPersons;

    public  User() {
    }

    public User(String username, String password, boolean enabled, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
    }

    public boolean isSubscriber(User user) {
//        boolean isUserSubscriber = this.getRequestsFromPersons().contains(user);
//        if(isUserSubscriber) return true;
        return true;
    }

    public User(String username, String password,
                boolean enabled, String email, UserRole userRole, Profile profile) {
        this(username, password, enabled, email);
        this.userRoles.addAll(userRoles);
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enable) {
        this.enabled = enable;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Set<FriendInvite> getPersonRequests() {
        return personRequests;
    }

    public void setPersonRequests(Set<FriendInvite> invites) {
        this.personRequests = invites;
    }

    public Set<FriendInvite> getRequestsFromPersons() {
        return requestsFromPersons;
    }

    public void setRequestsFromPersons(Set<FriendInvite> friendRequests) {
        this.requestsFromPersons = friendRequests;
    }
}

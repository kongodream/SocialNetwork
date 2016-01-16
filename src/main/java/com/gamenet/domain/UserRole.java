package com.gamenet.domain;

import javax.persistence.*;

/**
 * Created by ivan on 06.01.16.
 */
@Entity
@Table(name = "User_roles", uniqueConstraints = @UniqueConstraint(
        columnNames ={"username", "role_id"}))
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id",
            unique = true, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "username",  nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return getRole().getUserRole();
    }
}

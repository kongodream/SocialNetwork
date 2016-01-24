package com.gamenet.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ivan on 02.01.16.
 */
@Entity
@Table(name = "Friendinvites")
public class FriendInvite implements Serializable {

//    @Id
//    private int from;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "fromUser", column = @Column(name = "fromUser", nullable = false)),
            @AttributeOverride(name = "toUser", column = @Column(name = "toUser", nullable = false)) })
    private FriendInvitePK friendInvitePK;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fromUser", nullable = false, insertable = false, updatable = false)
    private User fromUser;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toUser", nullable = false, insertable = false, updatable = false)
    private User toUser;

    public FriendInvite() {}

    public FriendInvite(User fromUser, User toUser) {
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public FriendInvitePK getFriendInvitePK() {
        return friendInvitePK;
    }

    public void setFriendInvitePK(FriendInvitePK friendInvitePK) {
        this.friendInvitePK = friendInvitePK;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User from) {
        this.fromUser = from;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User to) {
        this.toUser = to;
    }


    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}

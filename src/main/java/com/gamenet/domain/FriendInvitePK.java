package com.gamenet.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by ivan on 21.01.16.
 */
@Embeddable
public class FriendInvitePK implements Serializable {

    @Column(name = "fromUser")
    public int fromUser;

    @Column(name = "toUser")
    public int toUser;

    public FriendInvitePK() {}

    public FriendInvitePK(int fromUser, int toUser) {
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public int getFromUser() {
        return fromUser;
    }

    public void setFromUser(int from) {
        this.fromUser = from;
    }

    public int getToUser() {
        return toUser;
    }

    public void setToUser(int to) {
        this.toUser = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FriendInvitePK)) return false;

        FriendInvitePK that = (FriendInvitePK) o;

        if (fromUser != that.fromUser) return false;
        if (toUser != that.toUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fromUser;
        result = 31 * result + toUser;
        return result;
    }
}

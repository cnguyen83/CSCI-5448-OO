package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "UserSessions", schema = "the_third_meal", catalog = "")
public class UserSessionsEntity {
    private String userSession;

    @Basic
    @Column(name = "UserSession")
    public String getUserSession() {
        return userSession;
    }

    public void setUserSession(String userSession) {
        this.userSession = userSession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSessionsEntity that = (UserSessionsEntity) o;

        if (userSession != null ? !userSession.equals(that.userSession) : that.userSession != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userSession != null ? userSession.hashCode() : 0;
    }
}

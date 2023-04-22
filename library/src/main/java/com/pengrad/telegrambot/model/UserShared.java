package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

public class UserShared implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer request_id;
    private Long user_id;

    public Integer requestId() {
        return request_id;
    }

    public Long userId() {
        return user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserShared that = (UserShared) o;

        return Objects.equals(request_id, that.request_id) &&
                Objects.equals(user_id, that.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request_id,
                user_id);
    }

    @Override
    public String toString() {
        return "UserShared{" +
                "request_id='" + request_id + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}

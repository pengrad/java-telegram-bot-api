package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class UsersShared implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer request_id;
    private Integer[] user_ids;

    public Integer requestId() {
        return request_id;
    }

    public Integer[] userIds() {
        return user_ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersShared that = (UsersShared) o;
        return Objects.equals(request_id, that.request_id) && Arrays.equals(user_ids, that.user_ids);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(request_id);
        result = 31 * result + Arrays.hashCode(user_ids);
        return result;
    }

    @Override
    public String toString() {
        return "UsersShared{" +
                "request_id='" + request_id + '\'' +
                ", user_ids='" + Arrays.toString(user_ids) + '\'' +
                '}';
    }
}

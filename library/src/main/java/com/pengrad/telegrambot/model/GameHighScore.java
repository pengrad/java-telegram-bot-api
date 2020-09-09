package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 04 October 2016
 */
public class GameHighScore implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer position;
    private User user;
    private Integer score;

    public Integer position() {
        return position;
    }

    public User user() {
        return user;
    }

    public Integer score() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameHighScore that = (GameHighScore) o;

        if (!Objects.equals(position, that.position)) return false;
        if (!Objects.equals(user, that.user)) return false;
        return Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GameHighScore{" +
                "position=" + position +
                ", user=" + user +
                ", score=" + score +
                '}';
    }
}

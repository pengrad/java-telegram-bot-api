package com.pengrad.telegrambot.model;

import java.io.Serializable;

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

        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return score != null ? score.equals(that.score) : that.score == null;
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

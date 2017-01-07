package com.pengrad.telegrambot.model;

/**
 * Stas Parshin
 * 04 October 2016
 */
public class GameHighScore {

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

        if (!position.equals(that.position)) return false;
        if (!user.equals(that.user)) return false;
        return score.equals(that.score);

    }

    @Override
    public int hashCode() {
        int result = position.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + score.hashCode();
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

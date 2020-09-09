package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * Stas Parshin
 * 17 April 2019
 */
public class Poll implements Serializable {
    private final static long serialVersionUID = 0L;

    public enum Type {
        quiz, regular
    }

    private String id;
    private String question;
    private PollOption[] options;
    private Integer total_voter_count;
    private Boolean is_closed;
    private Boolean is_anonymous;
    private Type type;
    private Boolean allows_multiple_answers;
    private Integer correct_option_id;
    private String explanation;
    private MessageEntity[] explanation_entities;
    private Integer open_period;
    private Integer close_date;

    public String id() {
        return id;
    }

    public String question() {
        return question;
    }

    public PollOption[] options() {
        return options;
    }

    public Integer totalVoterCount() {
        return total_voter_count;
    }

    public Boolean isClosed() {
        return is_closed;
    }

    public Boolean isAnonymous() {
        return is_anonymous;
    }

    public Type type() {
        return type;
    }

    public Boolean allowsMultipleAnswers() {
        return allows_multiple_answers;
    }

    public Integer correctOptionId() {
        return correct_option_id;
    }

    public String explanation() {
        return explanation;
    }

    public MessageEntity[] explanationEntities() {
        return explanation_entities;
    }

    public Integer openPeriod() {
        return open_period;
    }

    public Integer closeDate() {
        return close_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Poll poll = (Poll) o;

        if (!Objects.equals(id, poll.id)) return false;
        if (!Objects.equals(question, poll.question)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(options, poll.options)) return false;
        if (!Objects.equals(total_voter_count, poll.total_voter_count))
            return false;
        if (!Objects.equals(is_closed, poll.is_closed)) return false;
        if (!Objects.equals(is_anonymous, poll.is_anonymous)) return false;
        if (type != poll.type) return false;
        if (!Objects.equals(allows_multiple_answers, poll.allows_multiple_answers))
            return false;
        if (!Objects.equals(correct_option_id, poll.correct_option_id))
            return false;
        if (!Objects.equals(explanation, poll.explanation)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(explanation_entities, poll.explanation_entities)) return false;
        if (!Objects.equals(open_period, poll.open_period)) return false;
        return Objects.equals(close_date, poll.close_date);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", options=" + Arrays.toString(options) +
                ", total_voter_count=" + total_voter_count +
                ", is_closed=" + is_closed +
                ", is_anonymous=" + is_anonymous +
                ", type=" + type +
                ", allows_multiple_answers=" + allows_multiple_answers +
                ", correct_option_id=" + correct_option_id +
                ", explanation='" + explanation + '\'' +
                ", explanation_entities=" + Arrays.toString(explanation_entities) +
                ", open_period=" + open_period +
                ", close_date=" + close_date +
                '}';
    }
}

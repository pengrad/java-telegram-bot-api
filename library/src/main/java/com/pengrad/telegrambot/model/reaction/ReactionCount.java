package com.pengrad.telegrambot.model.reaction;

import java.util.Objects;

public class ReactionCount {

    private ReactionType type;
    private Integer total_count;

    public ReactionType type() {
        return type;
    }

    public Integer totalCount() {
        return total_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReactionCount that = (ReactionCount) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(total_count, that.total_count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, total_count);
    }

    @Override
    public String toString() {
        return "ReactionCount{" +
            "type=" + type +
            ", total_count=" + total_count +
            '}';
    }
}

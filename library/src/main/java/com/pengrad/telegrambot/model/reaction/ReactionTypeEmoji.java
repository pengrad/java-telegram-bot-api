package com.pengrad.telegrambot.model.reaction;

import java.util.Objects;

public class ReactionTypeEmoji extends ReactionType {

    public static final String EMOJI_TYPE = "emoji";

    private String emoji;

    public ReactionTypeEmoji(String emoji) {
        super(EMOJI_TYPE);
        this.emoji = emoji;
    }

    public String emoji() {
        return emoji;
    }

    public void emoji(String emoji) {
        this.emoji = emoji;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReactionTypeEmoji that = (ReactionTypeEmoji) o;
        return Objects.equals(emoji, that.emoji);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), emoji);
    }

    @Override
    public String toString() {
        return "ReactionTypeEmoji{" +
                "type='" + type() + '\'' +
                ",emoji='" + emoji + '\'' +
                '}';
    }
}

package com.pengrad.telegrambot.model.reaction;

import java.util.Objects;

public class ReactionTypeCustomEmoji extends ReactionType {

    public static final String CUSTOM_EMOJI_TYPE = "custom_emoji";

    private String custom_emoji_id;

    public ReactionTypeCustomEmoji(String customEmojiId) {
        super(CUSTOM_EMOJI_TYPE);
        this.custom_emoji_id = customEmojiId;
    }

    public String customEmojiId() {
        return custom_emoji_id;
    }

    public void customEmojiId(String customEmojiId) {
        this.custom_emoji_id = customEmojiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReactionTypeCustomEmoji that = (ReactionTypeCustomEmoji) o;
        return Objects.equals(custom_emoji_id, that.custom_emoji_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), custom_emoji_id);
    }

    @Override
    public String toString() {
        return "ReactionTypeCustomEmoji{" +
                "type='" + type() + '\'' +
                ",custom_emoji_id='" + custom_emoji_id + '\'' +
                '}';
    }
}

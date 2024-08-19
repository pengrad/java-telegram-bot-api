package com.pengrad.telegrambot.model.reaction;

import java.util.Objects;

public class ReactionTypePaid extends ReactionType {

    public static final String EMOJI_TYPE = "paid";

    public ReactionTypePaid() {
        super(EMOJI_TYPE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }

    @Override
    public String toString() {
        return "ReactionTypePaid{" +
            "type='" + type() + '\'' +
            '}';
    }
}

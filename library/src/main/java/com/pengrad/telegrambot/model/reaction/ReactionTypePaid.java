package com.pengrad.telegrambot.model.reaction;

public class ReactionTypePaid extends ReactionType {

    public static final String PAID_TYPE = "paid";

    public ReactionTypePaid() {
        super(PAID_TYPE);
    }

    @Override
    public String toString() {
        return "ReactionTypePaid{" +
                "type='" + type() + '\'' +
                '}';
    }
}

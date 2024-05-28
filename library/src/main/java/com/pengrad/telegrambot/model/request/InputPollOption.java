package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import com.pengrad.telegrambot.model.MessageEntity;

public class InputPollOption implements Serializable {

    private final static long serialVersionUID = 0L;

    private String text;
    private String text_parse_mode;
    private MessageEntity[] text_entities;

    public InputPollOption(String text) {
        this.text = text;
    }


    public InputPollOption textParseMode(String textParseMode) {
        this.text_parse_mode = textParseMode;
        return this;
    }

    public InputPollOption textEntities(MessageEntity... entities) {
        this.text_entities = entities;
        return this;
    }    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InputPollOption)) return false;
        InputPollOption that = (InputPollOption) o;
        return Objects.equals(text, that.text)
            && Objects.equals(text_parse_mode, that.text_parse_mode)
            && Arrays.equals(text_entities, that.text_entities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, text_parse_mode, text_entities);
    }

    @Override
    public String toString() {
        return "InputPollOption{" +
            "text='" + text + '\'' +
            ", text_parse_mode='" + text_parse_mode + '\'' +
            ", text_entities=" + Arrays.toString(text_entities) +
            '}';
    }
}

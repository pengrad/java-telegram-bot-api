package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class Update {

    private Integer update_id;
    private Message message;
    private InlineQuery inline_query;
    private ChosenInlineResult chosen_inline_result;

    Update() {
    }

    public Integer updateId() {
        return update_id;
    }

    public Message message() {
        return message;
    }

    public InlineQuery inlineQuery() {
        return inline_query;
    }

    public ChosenInlineResult chosenInlineResult() {
        return chosen_inline_result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Update update = (Update) o;

        if (update_id != null ? !update_id.equals(update.update_id) : update.update_id != null) return false;
        if (message != null ? !message.equals(update.message) : update.message != null) return false;
        if (inline_query != null ? !inline_query.equals(update.inline_query) : update.inline_query != null)
            return false;
        return chosen_inline_result != null ? chosen_inline_result.equals(update.chosen_inline_result) : update.chosen_inline_result == null;
    }

    @Override
    public int hashCode() {
        return update_id.hashCode();
    }

    @Override
    public String toString() {
        return "Update{" +
                "update_id=" + update_id +
                ", message=" + message +
                ", inline_query=" + inline_query +
                ", chosen_inline_result=" + chosen_inline_result +
                '}';
    }
}

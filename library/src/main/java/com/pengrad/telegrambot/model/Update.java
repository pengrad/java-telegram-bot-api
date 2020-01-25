package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * stas
 * 8/4/15.
 */
public class Update implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer update_id;
    private Message message;
    private Message edited_message;
    private Message channel_post;
    private Message edited_channel_post;
    private InlineQuery inline_query;
    private ChosenInlineResult chosen_inline_result;
    private CallbackQuery callback_query;
    private ShippingQuery shipping_query;
    private PreCheckoutQuery pre_checkout_query;
    private Poll poll;
    private PollAnswer poll_answer;

    public Integer updateId() {
        return update_id;
    }

    public Message message() {
        return message;
    }

    public Message editedMessage() {
        return edited_message;
    }

    public Message channelPost() {
        return channel_post;
    }

    public Message editedChannelPost() {
        return edited_channel_post;
    }

    public InlineQuery inlineQuery() {
        return inline_query;
    }

    public ChosenInlineResult chosenInlineResult() {
        return chosen_inline_result;
    }

    public CallbackQuery callbackQuery() {
        return callback_query;
    }

    public ShippingQuery shippingQuery() {
        return shipping_query;
    }

    public PreCheckoutQuery preCheckoutQuery() {
        return pre_checkout_query;
    }

    public Poll poll() {
        return poll;
    }

    public PollAnswer pollAnswer() {
        return poll_answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Update update = (Update) o;

        if (update_id != null ? !update_id.equals(update.update_id) : update.update_id != null) return false;
        if (message != null ? !message.equals(update.message) : update.message != null) return false;
        if (edited_message != null ? !edited_message.equals(update.edited_message) : update.edited_message != null)
            return false;
        if (channel_post != null ? !channel_post.equals(update.channel_post) : update.channel_post != null)
            return false;
        if (edited_channel_post != null ? !edited_channel_post.equals(update.edited_channel_post) : update.edited_channel_post != null)
            return false;
        if (inline_query != null ? !inline_query.equals(update.inline_query) : update.inline_query != null)
            return false;
        if (chosen_inline_result != null ? !chosen_inline_result.equals(update.chosen_inline_result) : update.chosen_inline_result != null)
            return false;
        if (callback_query != null ? !callback_query.equals(update.callback_query) : update.callback_query != null)
            return false;
        if (shipping_query != null ? !shipping_query.equals(update.shipping_query) : update.shipping_query != null)
            return false;
        if (pre_checkout_query != null ? !pre_checkout_query.equals(update.pre_checkout_query) : update.pre_checkout_query != null)
            return false;
        if (poll != null ? !poll.equals(update.poll) : update.poll != null) return false;
        return poll_answer != null ? poll_answer.equals(update.poll_answer) : update.poll_answer == null;
    }

    @Override
    public int hashCode() {
        return update_id != null ? update_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Update{" +
                "update_id=" + update_id +
                ", message=" + message +
                ", edited_message=" + edited_message +
                ", channel_post=" + channel_post +
                ", edited_channel_post=" + edited_channel_post +
                ", inline_query=" + inline_query +
                ", chosen_inline_result=" + chosen_inline_result +
                ", callback_query=" + callback_query +
                ", shipping_query=" + shipping_query +
                ", pre_checkout_query=" + pre_checkout_query +
                ", poll=" + poll +
                ", poll_answer=" + poll_answer +
                '}';
    }
}

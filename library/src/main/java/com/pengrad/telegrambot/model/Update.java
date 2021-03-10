package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

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
    private ChatMemberUpdated my_chat_member;
    private ChatMemberUpdated chat_member;

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

    public ChatMemberUpdated myChatMember() {
        return my_chat_member;
    }

    public ChatMemberUpdated chatMember() {
        return chat_member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Update update = (Update) o;
        return Objects.equals(update_id, update.update_id) &&
                Objects.equals(message, update.message) &&
                Objects.equals(edited_message, update.edited_message) &&
                Objects.equals(channel_post, update.channel_post) &&
                Objects.equals(edited_channel_post, update.edited_channel_post) &&
                Objects.equals(inline_query, update.inline_query) &&
                Objects.equals(chosen_inline_result, update.chosen_inline_result) &&
                Objects.equals(callback_query, update.callback_query) &&
                Objects.equals(shipping_query, update.shipping_query) &&
                Objects.equals(pre_checkout_query, update.pre_checkout_query) &&
                Objects.equals(poll, update.poll) &&
                Objects.equals(poll_answer, update.poll_answer) &&
                Objects.equals(my_chat_member, update.my_chat_member) &&
                Objects.equals(chat_member, update.chat_member);
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
                ", my_chat_member=" + my_chat_member +
                ", chat_member=" + chat_member +
                '}';
    }
}

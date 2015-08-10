package com.pengrad.telegrambot.request;

import retrofit.mime.TypedFile;

/**
 * stas
 * 8/4/15.
 */
public class SendPhotoRequest {

    private Integer chat_id;
    private Object photo;
    private String caption;
    private Integer reply_to_message_id;
    private Object reply_markup;

    public SendPhotoRequest(Integer chat_id, String photo) {
        this.chat_id = chat_id;
        this.photo = photo;
    }

    public SendPhotoRequest(Integer chat_id, TypedFile photo) {
        this.chat_id = chat_id;
        this.photo = photo;
    }

    public SendPhotoRequest caption(String caption) {
        this.caption = caption;
        return this;
    }

    public SendPhotoRequest replyToMessageId(Integer reply_to_message_id) {
        this.reply_to_message_id = reply_to_message_id;
        return this;
    }

    public SendPhotoRequest replyMarkup(Object reply_markup) {
        this.reply_markup = reply_markup;
        return this;
    }
}

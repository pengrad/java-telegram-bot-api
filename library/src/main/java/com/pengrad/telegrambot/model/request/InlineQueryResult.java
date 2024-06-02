package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.MessageEntity;

import java.io.Serializable;

/**
 * stas
 * 1/12/16.
 */
public abstract class InlineQueryResult<T extends InlineQueryResult<T>> implements Serializable {
    private final static long serialVersionUID = 0L;

    @SuppressWarnings("unchecked")
    private final T thisAsT = (T) this;

    private String type;
    private String id;
    private MessageEntity[] caption_entities;
    private InputMessageContent input_message_content;
    private InlineKeyboardMarkup reply_markup;
    private Boolean show_caption_above_media;

    public InlineQueryResult(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public T captionEntities(MessageEntity... entities) {
        this.caption_entities = entities;
        return thisAsT;
    }

    public T inputMessageContent(InputMessageContent inputMessageContent) {
        this.input_message_content = inputMessageContent;
        return thisAsT;
    }

    public T replyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.reply_markup = replyMarkup;
        return thisAsT;
    }

    public T showCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        this.show_caption_above_media = showCaptionAboveMedia;
        return thisAsT;
    }

}

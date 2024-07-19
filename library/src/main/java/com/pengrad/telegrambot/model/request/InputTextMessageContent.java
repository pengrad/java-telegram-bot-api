package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.LinkPreviewOptions;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.request.EditMessageText;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InputTextMessageContent extends InputMessageContent implements Serializable {
    private final static long serialVersionUID = 0L;

    private String message_text;
    private String parse_mode;
    private LinkPreviewOptions link_preview_options;
    private Boolean disable_web_page_preview;
    private MessageEntity[] entities;

    public InputTextMessageContent(String messageText) {
        this.message_text = messageText;
    }

    public InputTextMessageContent parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }

    public InputTextMessageContent entities(MessageEntity... entities) {
        this.entities = entities;
        return this;
    }

    public InputTextMessageContent linkPreviewOptions(LinkPreviewOptions linkPreviewOptions) {
        this.link_preview_options = linkPreviewOptions;
        return this;
    }

    /*
    @deprecated Use linkPreviewOptions instead
    */
    @Deprecated
    public InputTextMessageContent disableWebPagePreview(Boolean disableWebPagePreview) {
        this.disable_web_page_preview = disableWebPagePreview;
        return this;
    }
}

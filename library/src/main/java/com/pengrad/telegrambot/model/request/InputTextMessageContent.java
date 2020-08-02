package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InputTextMessageContent extends InputMessageContent implements Serializable {
    private final static long serialVersionUID = 0L;

    private String message_text;
    private String parse_mode;
    private Boolean disable_web_page_preview;

    public InputTextMessageContent(String messageText) {
        this.message_text = messageText;
    }

    public InputTextMessageContent parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }

    public InputTextMessageContent disableWebPagePreview(Boolean disableWebPagePreview) {
        this.disable_web_page_preview = disableWebPagePreview;
        return this;
    }
}

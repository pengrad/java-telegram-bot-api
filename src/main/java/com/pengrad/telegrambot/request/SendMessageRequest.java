package com.pengrad.telegrambot.request;

/**
 * stas
 * 8/4/15.
 */
public class SendMessageRequest {

    private Integer chat_id;
    private String text;
    private boolean disable_web_page_preview = false;
    private Integer reply_to_message_id = null;
    private Object reply_markup = null;


    public SendMessageRequest(Integer chat_id, String text) {
        this.chat_id = chat_id;
        this.text = text;
    }

    public SendMessageRequest disableWebPagePreview(boolean disable_web_page_preview) {
        this.disable_web_page_preview = disable_web_page_preview;
        return this;
    }

    public SendMessageRequest replyToMessageId(Integer reply_to_message_id) {
        this.reply_to_message_id = reply_to_message_id;
        return this;
    }

    public SendMessageRequest replyMarkup(Object reply_markup) {
        this.reply_markup = reply_markup;
        return this;
    }
}

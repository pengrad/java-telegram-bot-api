package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.model.request.ParseMode;

/**
 * stas
 * 5/1/16.
 */
public class SendMessageRequest extends AbstractSendRequest<SendMessageRequest> {

    public SendMessageRequest(TelegramApi api, Object chatId, String text) {
        super(api, chatId);
        add("text", text);
    }

    public SendMessageRequest parseMode(ParseMode parseMode) {
        add("parse_mode", parseMode.name());
        return this;
    }

    public SendMessageRequest disableWebPagePreview(boolean disableWebPagePreview) {
        add("disable_web_page_preview", disableWebPagePreview);
        return this;
    }

    @Override
    public String getMethod() {
        return "sendMessage";
    }
}

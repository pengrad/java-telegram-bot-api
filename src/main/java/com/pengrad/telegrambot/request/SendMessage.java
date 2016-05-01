package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.model.request.ParseMode;

/**
 * stas
 * 5/1/16.
 */
public class SendMessage extends AbstractSendRequest<SendMessage> {

    public SendMessage(TelegramApi api, Object chatId, String text) {
        super(api, chatId);
        add("text", text);
    }

    public SendMessage parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendMessage disableWebPagePreview(boolean disableWebPagePreview) {
        return add("disable_web_page_preview", disableWebPagePreview);
    }

    @Override
    public String getMethod() {
        return "sendMessage";
    }
}

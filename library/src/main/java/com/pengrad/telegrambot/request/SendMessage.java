package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.LinkPreviewOptions;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;

/**
 * stas
 * 5/1/16.
 */
public class SendMessage extends AbstractSendRequest<SendMessage> {

    public SendMessage(Object chatId, String text) {
        super(chatId);
        add("text", text);
    }

    public SendMessage parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendMessage entities(MessageEntity... entities) {
        return add("entities", entities);
    }

    public SendMessage linkPreviewOptions(LinkPreviewOptions linkPreviewOptions) {
        return add("link_preview_options", linkPreviewOptions);
    }

    /*
    @deprecated Use linkPreviewOptions instead
    */
    @Deprecated
    public SendMessage disableWebPagePreview(boolean disableWebPagePreview) {
        return add("disable_web_page_preview", disableWebPagePreview);
    }
}

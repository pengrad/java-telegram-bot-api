package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.InputMedia;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.Map;

/**
 * Stas Parshin
 * 28 July 2018
 */
public class EditMessageMedia extends BaseRequest<EditMessageMedia, BaseResponse> {

    private boolean isMultipart;
    private InputMedia<?> media;

    public EditMessageMedia(TelegramBotClient api, Object chatId, int messageId, InputMedia<?> media) {
        super(api, SendResponse.class);
        add("chat_id", chatId).add("message_id", messageId);
        addMedia(media);
    }

    public EditMessageMedia(TelegramBotClient api, String inlineMessageId, InputMedia<?> media) {
        super(api, BaseResponse.class);
        add("inline_message_id", inlineMessageId);
        addMedia(media);
    }

    private void addMedia(InputMedia<?> media) {
        this.media = media;
        add("media", media);
        Map<String, Object> attachments = media.getAttachments();
        if (attachments != null && attachments.size() > 0) {
            addAll(attachments);
            isMultipart = true;
        }
        if (media.inputFile() != null) {
            add(media.getInputFileId(), media.inputFile());
            isMultipart = true;
        }
    }

    public EditMessageMedia replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    @Override
    public boolean isMultipart() {
        return isMultipart;
    }

    @Override
    public String getFileName() {
        return media.getFileName();
    }

    @Override
    public String getContentType() {
        return media.getContentType();
    }
}

package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.response.SendResponse;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * stas
 * 5/1/16.
 */
public class SendMessageRequest extends BaseRequest<SendResponse> {


    private final FormBody.Builder builder;

    public SendMessageRequest(TelegramApi api, Object chatId, String text) {
        super(api, SendResponse.class);
        builder = new FormBody.Builder()
                .add("chat_id", String.valueOf(chatId))
                .add("text", text);
    }

    public SendMessageRequest parseMode(ParseMode parseMode) {
        builder.add("parse_mode", parseMode.name());
        return this;
    }

    public SendMessageRequest disableWebPagePreview(boolean disableWebPagePreview) {
        builder.add("disable_web_page_preview", String.valueOf(disableWebPagePreview));
        return this;
    }

    public SendMessageRequest replyToMessageId(int replyToMessageId) {
        builder.add("reply_to_message_id", String.valueOf(replyToMessageId));
        return this;
    }

    public SendMessageRequest replyMarkup(Keyboard replyMarkup) {
        builder.add("reply_markup", replyMarkup.toString());
        return this;
    }

    @Override
    public String getMethod() {
        return "sendMessage";
    }

    @Override
    public RequestBody getRequestBody() {
        return builder.build();
    }
}

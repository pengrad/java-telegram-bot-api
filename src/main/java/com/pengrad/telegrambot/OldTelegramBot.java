package com.pengrad.telegrambot;

import com.google.gson.Gson;
import com.pengrad.telegrambot.impl.BotApi;
import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.*;

/**
 * stas
 * 5/1/16.
 */
@Deprecated
public class OldTelegramBot {

    private BotApi botApi;
    private Gson gson;
    private final FileApi fileApi;
    private final TelegramApi api;

    OldTelegramBot(TelegramApi api, FileApi fileApi) {
        this.api = api;
        this.fileApi = fileApi;
    }

    @Deprecated
    public SendResponse sendMessage(Object chatId, String text, ParseMode parseMode, Boolean disableWebPagePreview, Integer replyToMessageId, Keyboard replyMarkup) {
        SendMessage request = new SendMessage(api, chatId, text);
        if (parseMode != null) request.parseMode(parseMode);
        if (disableWebPagePreview != null) request.disableWebPagePreview(disableWebPagePreview);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public SendResponse forwardMessage(Object chatId, Object fromChatId, Integer messageId) {
        return new ForwardMessage(api, chatId, fromChatId, messageId).execute();
    }

    @Deprecated
    public SendResponse sendPhoto(Object chatId, String photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendPhoto(chatId, photo, caption, replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendPhoto(Object chatId, InputFile photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendPhoto(chatId, photo.getFile(), caption, replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendPhoto(Object chatId, InputFileBytes photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendPhoto(chatId, photo.getBytes(), caption, replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendPhoto(Object chatId, Object photo, String caption, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        SendPhoto request = new SendPhoto(api, chatId, photo, isMultipart);
        if (caption != null) request.caption(caption);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public SendResponse sendAudio(Object chatId, String audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendAudio(chatId, audio, duration, performer, title, replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendAudio(Object chatId, InputFile audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendAudio(chatId, audio.getFile(), duration, performer, title, replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendAudio(Object chatId, InputFileBytes audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendAudio(chatId, audio.getBytes(), duration, performer, title, replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendAudio(Object chatId, Object audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        SendAudio request = new SendAudio(api, chatId, audio, isMultipart);
        if (duration != null) request.duration(duration);
        if (performer != null) request.performer(performer);
        if (title != null) request.title(title);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public SendResponse sendDocument(Object chatId, String document, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendDocument(chatId, document, replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendDocument(Object chatId, InputFile document, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendDocument(chatId, document.getFile(), replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendDocument(Object chatId, InputFileBytes document, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendDocument(chatId, document.getBytes(), replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendDocument(Object chatId, Object document, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        SendDocument request = new SendDocument(api, chatId, document, isMultipart);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public SendResponse sendSticker(Object chatId, String sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendSticker(chatId, sticker, replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendSticker(Object chatId, InputFile sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendSticker(chatId, sticker.getFile(), replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendSticker(Object chatId, InputFileBytes sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendSticker(chatId, sticker.getBytes(), replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendSticker(Object chatId, Object sticker, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        SendSticker request = new SendSticker(api, chatId, sticker, isMultipart);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public SendResponse sendVideo(Object chatId, String video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVideo(chatId, video, duration, caption, replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendVideo(Object chatId, InputFile video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVideo(chatId, video.getFile(), duration, caption, replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendVideo(Object chatId, InputFileBytes video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVideo(chatId, video.getBytes(), duration, caption, replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendVideo(Object chatId, Object video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        SendVideo request = new SendVideo(api, chatId, video, isMultipart);
        if (duration != null) request.duration(duration);
        if (caption != null) request.caption(caption);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public SendResponse sendVoice(Object chatId, String voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVoice(chatId, voice, duration, replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendVoice(Object chatId, InputFile voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVoice(chatId, voice.getFile(), duration, replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendVoice(Object chatId, InputFileBytes voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVoice(chatId, voice.getBytes(), duration, replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendVoice(Object chatId, Object voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        SendVoice request = new SendVoice(api, chatId, voice, isMultipart);
        if (duration != null) request.duration(duration);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public SendResponse sendLocation(Object chatId, Float latitude, Float longitude, Integer replyToMessageId, Keyboard replyMarkup) {
        SendLocation request = new SendLocation(api, chatId, latitude, longitude);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public GetUserProfilePhotosResponse getUserProfilePhotos(Integer userId, Integer offset, Integer limit) {
        GetUserProfilePhotos request = new GetUserProfilePhotos(api, userId);
        if (offset != null) request.offset(offset);
        if (limit != null) request.limit(limit);
        return request.execute();
    }

    @Deprecated
    public GetUpdatesResponse getUpdates(Integer offset, Integer limit, Integer timeout) {
        GetUpdates request = new GetUpdates(api);
        if (offset != null) request.offset(offset);
        if (limit != null) request.limit(limit);
        if (timeout != null) request.timeout(timeout);
        return request.execute();
    }

    @Deprecated
    public BaseResponse setWebhook(String url) {
        return botApi.setWebhook(url);
    }

    @Deprecated
    public BaseResponse setWebhook(String url, InputFile certificate) {
        return botApi.setWebhook(url, certificate);
    }

    @Deprecated
    public BaseResponse setWebhook(String url, InputFileBytes certificate) {
        return botApi.setWebhook(url, certificate);
    }

    @Deprecated
    public BaseResponse answerInlineQuery(String inlineQueryId, InlineQueryResult... results) {
        return answerInlineQuery(inlineQueryId, results, null, null, null);
    }

    @Deprecated
    public BaseResponse answerInlineQuery(String inlineQueryId, InlineQueryResult[] results, Integer cacheTime, Boolean isPersonal, String nextOffset) {
        return botApi.answerInlineQuery(inlineQueryId, gson.toJson(results), cacheTime, isPersonal, nextOffset);
    }

}

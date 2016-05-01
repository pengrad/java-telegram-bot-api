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

    BotApi botApi;
    Gson gson;
    private final FileApi fileApi;
    private final TelegramApi api;

    OldTelegramBot(TelegramApi api, FileApi fileApi) {
        this.api = api;
        this.fileApi = fileApi;
    }

    @Deprecated
    public SendResponse sendMessage(Object chatId, String text, ParseMode parseMode, Boolean disableWebPagePreview, Integer replyToMessageId, Keyboard replyMarkup) {
        SendMessageRequest request = new SendMessageRequest(api, chatId, text);
        if (parseMode != null) request.parseMode(parseMode);
        if (disableWebPagePreview != null) request.disableWebPagePreview(disableWebPagePreview);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public SendResponse forwardMessage(Object chatId, Object fromChatId, Integer messageId) {
        return new ForwardMessageRequest(api, chatId, fromChatId, messageId).execute();
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
        SendPhotoRequest request = new SendPhotoRequest(api, chatId, photo, isMultipart);
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
        SendAudioRequest request = new SendAudioRequest(api, chatId, audio, isMultipart);
        if (duration != null) request.duration(duration);
        if (performer != null) request.performer(performer);
        if (title != null) request.title(title);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public SendResponse sendDocument(Object chatId, String document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(String.valueOf(chatId), document, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendDocument(Object chatId, InputFile document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(String.valueOf(chatId), document, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendDocument(Object chatId, InputFileBytes document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(String.valueOf(chatId), document, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendSticker(Object chatId, String sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(String.valueOf(chatId), sticker, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendSticker(Object chatId, InputFile sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(String.valueOf(chatId), sticker, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendSticker(Object chatId, InputFileBytes sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(String.valueOf(chatId), sticker, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendVideo(Object chatId, String video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(String.valueOf(chatId), video, duration, caption, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendVideo(Object chatId, InputFile video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(String.valueOf(chatId), video, duration, caption, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendVideo(Object chatId, InputFileBytes video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(String.valueOf(chatId), video, duration, caption, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendVoice(Object chatId, String voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(String.valueOf(chatId), voice, duration, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendVoice(Object chatId, InputFile voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(String.valueOf(chatId), voice, duration, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendVoice(Object chatId, InputFileBytes voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(String.valueOf(chatId), voice, duration, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendLocation(Object chatId, Float latitude, Float longitude, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendLocation(String.valueOf(chatId), latitude, longitude, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendChatActionResponse sendChatAction(Object chatId, ChatAction action) {
        return botApi.sendChatAction(String.valueOf(chatId), action);
    }

    @Deprecated
    public GetUserProfilePhotosResponse getUserProfilePhotos(Integer userId, Integer offset, Integer limit) {
        return botApi.getUserProfilePhotos(userId, offset, limit);
    }

    @Deprecated
    public GetUpdatesResponse getUpdates(Integer offset, Integer limit, Integer timeout) {
        return botApi.getUpdates(offset, limit, timeout);
    }

    @Deprecated
    public SetWebhookResponse setWebhook(String url) {
        return botApi.setWebhook(url);
    }

    @Deprecated
    public SetWebhookResponse setWebhook(String url, InputFile certificate) {
        return botApi.setWebhook(url, certificate);
    }

    @Deprecated
    public SetWebhookResponse setWebhook(String url, InputFileBytes certificate) {
        return botApi.setWebhook(url, certificate);
    }

    @Deprecated
    public GetFileResponse getFile(String fileId) {
        return new GetFileRequest(api, fileId).execute();
    }

    @Deprecated
    public OkResponse answerInlineQuery(String inlineQueryId, InlineQueryResult... results) {
        return answerInlineQuery(inlineQueryId, results, null, null, null);
    }

    @Deprecated
    public OkResponse answerInlineQuery(String inlineQueryId, InlineQueryResult[] results, Integer cacheTime, Boolean isPersonal, String nextOffset) {
        return botApi.answerInlineQuery(inlineQueryId, gson.toJson(results), cacheTime, isPersonal, nextOffset);
    }

}

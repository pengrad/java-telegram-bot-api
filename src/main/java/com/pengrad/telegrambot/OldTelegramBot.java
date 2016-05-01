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
        SendDocumentRequest request = new SendDocumentRequest(api, chatId, document, isMultipart);
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
        SendStickerRequest request = new SendStickerRequest(api, chatId, sticker, isMultipart);
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
        SendVideoRequest request = new SendVideoRequest(api, chatId, video, isMultipart);
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
        SendVoiceRequest request = new SendVoiceRequest(api, chatId, voice, isMultipart);
        if (duration != null) request.duration(duration);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
    }

    @Deprecated
    public SendResponse sendLocation(Object chatId, Float latitude, Float longitude, Integer replyToMessageId, Keyboard replyMarkup) {
        SendLocationRequest request = new SendLocationRequest(api, chatId, latitude, longitude);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return request.execute();
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

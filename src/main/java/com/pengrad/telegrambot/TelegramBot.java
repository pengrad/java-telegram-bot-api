package com.pengrad.telegrambot;

import com.google.gson.Gson;
import com.pengrad.telegrambot.impl.BotApi;
import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.GetFileRequest;
import com.pengrad.telegrambot.request.GetMeRequest;
import com.pengrad.telegrambot.request.SendMessageRequest;
import com.pengrad.telegrambot.request.SendPhotoRequest;
import com.pengrad.telegrambot.response.*;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class TelegramBot {

    private final FileApi fileApi;
    private final TelegramApi api;

    private BotApi botApi;
    private Gson gson;

    public TelegramBot(TelegramApi api, FileApi fileApi) {
        this.api = api;
        this.fileApi = fileApi;
    }

    public String getFullFilePath(String fileId) {
        GetFileResponse fileResponse = new GetFileRequest(api, fileId).execute();
        if (!fileResponse.isOk() || fileResponse.file() == null) {
            return null;
        }
        return fileApi.getFullFilePath(fileResponse.file().filePath());
    }

    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file.filePath());
    }

    public GetMeResponse getMe() {
        return new GetMeRequest(api).execute();
    }

    public SendResponse sendMessage(Object chatId, String text) {
        return new SendMessageRequest(api, chatId, text).execute();
    }

    public SendResponse sendMessage(Object chatId, String text, ParseMode parseMode, Boolean disableWebPagePreview, Integer replyToMessageId, Keyboard replyMarkup) {
        SendMessageRequest request = new SendMessageRequest(api, chatId, text);

        if (parseMode != null) request.parseMode(parseMode);
        if (disableWebPagePreview != null) request.disableWebPagePreview(disableWebPagePreview);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);

        return request.execute();
    }

    public SendResponse forwardMessage(Object chatId, Object fromChatId, Integer messageId) {
        FormBody.Builder builder = new FormBody.Builder()
                .add("chat_id", String.valueOf(chatId))
                .add("from_chat_id", String.valueOf(fromChatId))
                .add("message_id", String.valueOf(messageId));
        return botApi.forwardMessage(builder.build());
    }

    public SendResponse sendPhoto(Object chatId, InputFile photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return new SendPhotoRequest(api, chatId, photo.getFile()).caption(caption).execute();
    }

    public SendResponse sendPhoto(Object chatId, InputFileBytes photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        final RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("chat_id", String.valueOf(chatId))
                .addFormDataPart("photo", photo.fileName(), photo)
                .addFormDataPart("caption", caption)
                .build();

        return null;
    }

    public SendResponse sendAudio(Object chatId, String audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(String.valueOf(chatId), audio, duration, performer, title, replyToMessageId, replyMarkup);
    }

    public SendResponse sendAudio(Object chatId, InputFile audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(String.valueOf(chatId), audio, duration, performer, title, replyToMessageId, replyMarkup);
    }

    public SendResponse sendAudio(Object chatId, InputFileBytes audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(String.valueOf(chatId), audio, duration, performer, title, replyToMessageId, replyMarkup);
    }

    public SendResponse sendDocument(Object chatId, String document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(String.valueOf(chatId), document, replyToMessageId, replyMarkup);
    }

    public SendResponse sendDocument(Object chatId, InputFile document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(String.valueOf(chatId), document, replyToMessageId, replyMarkup);
    }

    public SendResponse sendDocument(Object chatId, InputFileBytes document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(String.valueOf(chatId), document, replyToMessageId, replyMarkup);
    }

    public SendResponse sendSticker(Object chatId, String sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(String.valueOf(chatId), sticker, replyToMessageId, replyMarkup);
    }

    public SendResponse sendSticker(Object chatId, InputFile sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(String.valueOf(chatId), sticker, replyToMessageId, replyMarkup);
    }

    public SendResponse sendSticker(Object chatId, InputFileBytes sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(String.valueOf(chatId), sticker, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVideo(Object chatId, String video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(String.valueOf(chatId), video, duration, caption, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVideo(Object chatId, InputFile video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(String.valueOf(chatId), video, duration, caption, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVideo(Object chatId, InputFileBytes video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(String.valueOf(chatId), video, duration, caption, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVoice(Object chatId, String voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(String.valueOf(chatId), voice, duration, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVoice(Object chatId, InputFile voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(String.valueOf(chatId), voice, duration, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVoice(Object chatId, InputFileBytes voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(String.valueOf(chatId), voice, duration, replyToMessageId, replyMarkup);
    }

    public SendResponse sendLocation(Object chatId, Float latitude, Float longitude, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendLocation(String.valueOf(chatId), latitude, longitude, replyToMessageId, replyMarkup);
    }

    public SendChatActionResponse sendChatAction(Object chatId, ChatAction action) {
        return botApi.sendChatAction(String.valueOf(chatId), action);
    }

    public GetUserProfilePhotosResponse getUserProfilePhotos(Integer userId, Integer offset, Integer limit) {
        return botApi.getUserProfilePhotos(userId, offset, limit);
    }

    public GetUpdatesResponse getUpdates(Integer offset, Integer limit, Integer timeout) {
        return botApi.getUpdates(offset, limit, timeout);
    }

    public SetWebhookResponse setWebhook(String url) {
        return botApi.setWebhook(url);
    }

    public SetWebhookResponse setWebhook(String url, InputFile certificate) {
        return botApi.setWebhook(url, certificate);
    }

    public SetWebhookResponse setWebhook(String url, InputFileBytes certificate) {
        return botApi.setWebhook(url, certificate);
    }

    public GetFileResponse getFile(String fileId) {
        return new GetFileRequest(api, fileId).execute();
    }

    public OkResponse answerInlineQuery(String inlineQueryId, InlineQueryResult... results) {
        return answerInlineQuery(inlineQueryId, results, null, null, null);
    }

    public OkResponse answerInlineQuery(String inlineQueryId, InlineQueryResult[] results, Integer cacheTime, Boolean isPersonal, String nextOffset) {
        return botApi.answerInlineQuery(inlineQueryId, gson.toJson(results), cacheTime, isPersonal, nextOffset);
    }
}

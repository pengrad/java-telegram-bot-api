package com.pengrad.telegrambot;

import com.pengrad.telegrambot.impl.BotApi;
import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.model.request.InputFile;
import com.pengrad.telegrambot.model.request.InputFileBytes;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.response.*;
import retrofit.Callback;
import rx.Observable;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class TelegramBot implements BotApi {

    private final BotApi botApi;
    private final FileApi fileApi;

    public TelegramBot(BotApi botApi, FileApi fileApi) {
        this.botApi = botApi;
        this.fileApi = fileApi;
    }

    public String getFullFilePath(String fileId) {
        GetFileResponse fileResponse = botApi.getFile(fileId);
        if (!fileResponse.ok || fileResponse.result == null) {
            return null;
        }
        return fileApi.getFullFilePath(fileResponse.result.file_path);
    }

    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file.file_path);
    }

    @Override
    public GetMeResponse getMe() {
        return botApi.getMe();
    }

    @Override
    public void getMe(Callback<GetMeResponse> callback) {
        botApi.getMe(callback);
    }

    @Override
    public Observable<GetMeResponse> getMeRx() {
        return botApi.getMeRx();
    }

    @Override
    public SendResponse sendMessage(Integer chatId, String text, Boolean disableWebPagePreview, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendMessage(chatId, text, disableWebPagePreview, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendMessage(Integer chatId, String text, Boolean disableWebPagePreview, Integer replyToMessageId, Keyboard replyMarkup, Callback<SendResponse> callback) {
        return botApi.sendMessage(chatId, text, disableWebPagePreview, replyToMessageId, replyMarkup, callback);
    }

    @Override
    public Observable<SendResponse> sendMessageRx(Integer chatId, String text, Boolean disableWebPagePreview, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendMessageRx(chatId, text, disableWebPagePreview, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse forwardMessage(Integer chatId, Integer fromChatId, Integer messageId) {
        return botApi.forwardMessage(chatId, fromChatId, messageId);
    }

    @Override
    public SendResponse sendPhoto(Integer chatId, String photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendPhoto(chatId, photo, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendPhoto(Integer chatId, InputFile photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendPhoto(chatId, photo, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendPhoto(Integer chatId, InputFileBytes photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendPhoto(chatId, photo, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendAudio(Integer chatId, String audio, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(chatId, audio, duration, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendAudio(Integer chatId, InputFile audio, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(chatId, audio, duration, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendAudio(Integer chatId, InputFileBytes audio, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(chatId, audio, duration, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendDocument(Integer chatId, String document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(chatId, document, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendDocument(Integer chatId, InputFile document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(chatId, document, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendDocument(Integer chatId, InputFileBytes document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(chatId, document, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendSticker(Integer chatId, String sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(chatId, sticker, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendSticker(Integer chatId, InputFile sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(chatId, sticker, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendSticker(Integer chatId, InputFileBytes sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(chatId, sticker, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendVideo(Integer chatId, String video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(chatId, video, duration, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendVideo(Integer chatId, InputFile video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(chatId, video, duration, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendVideo(Integer chatId, InputFileBytes video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(chatId, video, duration, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendLocation(Integer chatId, Float latitude, Float longitude, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendLocation(chatId, latitude, longitude, replyToMessageId, replyMarkup);
    }

    @Override
    public SendChatActionResponse sendChatAction(Integer chatId, String action) {
        return botApi.sendChatAction(chatId, action);
    }

    @Override
    public GetUserProfilePhotosResponse getUserProfilePhotos(Integer userId, Integer offset, Integer limit) {
        return botApi.getUserProfilePhotos(userId, offset, limit);
    }

    @Override
    public GetUpdatesResponse getUpdates(Integer offset, Integer limit, Integer timeout) {
        return botApi.getUpdates(offset, limit, timeout);
    }

    @Override
    public SetWebhookResponse setWebhook(String url) {
        return botApi.setWebhook(url);
    }

    @Override
    public GetFileResponse getFile(String fileId) {
        return botApi.getFile(fileId);
    }
}

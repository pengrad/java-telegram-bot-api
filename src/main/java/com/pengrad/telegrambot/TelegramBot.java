package com.pengrad.telegrambot;

import com.pengrad.telegrambot.impl.BotApi;
import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.response.*;

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
        if (!fileResponse.isOk() || fileResponse.file() == null) {
            return null;
        }
        return fileApi.getFullFilePath(fileResponse.file().filePath());
    }

    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file.filePath());
    }

    @Override
    public GetMeResponse getMe() {
        return botApi.getMe();
    }

    @Override
    public SendResponse sendMessage(Integer chatId, String text, ParseMode parse_mode, Boolean disableWebPagePreview, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendMessage(chatId, text, parse_mode, disableWebPagePreview, replyToMessageId, replyMarkup);
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
    public SendResponse sendAudio(Integer chatId, String audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(chatId, audio, duration, performer, title, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendAudio(Integer chatId, InputFile audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(chatId, audio, duration, performer, title, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendAudio(Integer chatId, InputFileBytes audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(chatId, audio, duration, performer, title, replyToMessageId, replyMarkup);
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
    public SendResponse sendVoice(Integer chatId, String voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(chatId, voice, duration, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendVoice(Integer chatId, InputFile voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(chatId, voice, duration, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendVoice(Integer chatId, InputFileBytes voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(chatId, voice, duration, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendLocation(Integer chatId, Float latitude, Float longitude, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendLocation(chatId, latitude, longitude, replyToMessageId, replyMarkup);
    }

    @Override
    public SendChatActionResponse sendChatAction(Integer chatId, ChatAction action) {
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
    public SetWebhookResponse setWebhook(String url, InputFile certificate) {
        return botApi.setWebhook(url, certificate);
    }

    @Override
    public SetWebhookResponse setWebhook(String url, InputFileBytes certificate) {
        return botApi.setWebhook(url, certificate);
    }

    @Override
    public GetFileResponse getFile(String fileId) {
        return botApi.getFile(fileId);
    }
}

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
public class TelegramBot {

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

    public GetMeResponse getMe() {
        return botApi.getMe();
    }

    public SendResponse sendMessage(Long chatId, String text, ParseMode parse_mode, Boolean disableWebPagePreview, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendMessage(String.valueOf(chatId), text, parse_mode, disableWebPagePreview, replyToMessageId, replyMarkup);
    }

    public SendResponse forwardMessage(Long chatId, Long fromChatId, Integer messageId) {
        return botApi.forwardMessage(String.valueOf(chatId), String.valueOf(fromChatId), messageId);
    }

    public SendResponse sendPhoto(Long chatId, String photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendPhoto(String.valueOf(chatId), photo, caption, replyToMessageId, replyMarkup);
    }

    public SendResponse sendPhoto(Long chatId, InputFile photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendPhoto(String.valueOf(chatId), photo, caption, replyToMessageId, replyMarkup);
    }

    public SendResponse sendPhoto(Long chatId, InputFileBytes photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendPhoto(String.valueOf(chatId), photo, caption, replyToMessageId, replyMarkup);
    }

    public SendResponse sendAudio(Long chatId, String audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(String.valueOf(chatId), audio, duration, performer, title, replyToMessageId, replyMarkup);
    }

    public SendResponse sendAudio(Long chatId, InputFile audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(String.valueOf(chatId), audio, duration, performer, title, replyToMessageId, replyMarkup);
    }

    public SendResponse sendAudio(Long chatId, InputFileBytes audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendAudio(String.valueOf(chatId), audio, duration, performer, title, replyToMessageId, replyMarkup);
    }

    public SendResponse sendDocument(Long chatId, String document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(String.valueOf(chatId), document, replyToMessageId, replyMarkup);
    }

    public SendResponse sendDocument(Long chatId, InputFile document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(String.valueOf(chatId), document, replyToMessageId, replyMarkup);
    }

    public SendResponse sendDocument(Long chatId, InputFileBytes document, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendDocument(String.valueOf(chatId), document, replyToMessageId, replyMarkup);
    }

    public SendResponse sendSticker(Long chatId, String sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(String.valueOf(chatId), sticker, replyToMessageId, replyMarkup);
    }

    public SendResponse sendSticker(Long chatId, InputFile sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(String.valueOf(chatId), sticker, replyToMessageId, replyMarkup);
    }

    public SendResponse sendSticker(Long chatId, InputFileBytes sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendSticker(String.valueOf(chatId), sticker, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVideo(Long chatId, String video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(String.valueOf(chatId), video, duration, caption, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVideo(Long chatId, InputFile video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(String.valueOf(chatId), video, duration, caption, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVideo(Long chatId, InputFileBytes video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVideo(String.valueOf(chatId), video, duration, caption, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVoice(Long chatId, String voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(String.valueOf(chatId), voice, duration, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVoice(Long chatId, InputFile voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(String.valueOf(chatId), voice, duration, replyToMessageId, replyMarkup);
    }

    public SendResponse sendVoice(Long chatId, InputFileBytes voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendVoice(String.valueOf(chatId), voice, duration, replyToMessageId, replyMarkup);
    }

    public SendResponse sendLocation(Long chatId, Float latitude, Float longitude, Integer replyToMessageId, Keyboard replyMarkup) {
        return botApi.sendLocation(String.valueOf(chatId), latitude, longitude, replyToMessageId, replyMarkup);
    }

    public SendChatActionResponse sendChatAction(Long chatId, ChatAction action) {
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
        return botApi.getFile(fileId);
    }
}

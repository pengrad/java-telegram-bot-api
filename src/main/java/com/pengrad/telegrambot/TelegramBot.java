package com.pengrad.telegrambot;

import com.pengrad.telegrambot.impl.BotApi;
import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.model.InputFile;
import com.pengrad.telegrambot.model.InputFileBytes;
import com.pengrad.telegrambot.model.Keyboard;
import com.pengrad.telegrambot.response.GetFileResponse;
import com.pengrad.telegrambot.response.GetMeResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.GetUserProfilePhotos;
import com.pengrad.telegrambot.response.SendChatActionResponse;
import com.pengrad.telegrambot.response.SendResponse;
import com.pengrad.telegrambot.response.SetWebhookResponse;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.Part;
import retrofit.http.Query;
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
        return fileApi.getFullFilePath(fileResponse.result.getFilePath());
    }

    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file.getFilePath());
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
    public SendResponse sendMessage(@Field("chat_id") Integer chatId, @Field("text") String text, @Field("disable_web_page_preview") Boolean disableWebPagePreview, @Field("reply_to_message_id") Integer replyToMessageId, @Field("reply_markup") Keyboard replyMarkup) {
        return botApi.sendMessage(chatId, text, disableWebPagePreview, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendMessage(@Field("chat_id") Integer chatId, @Field("text") String text, @Field("disable_web_page_preview") Boolean disableWebPagePreview, @Field("reply_to_message_id") Integer replyToMessageId, @Field("reply_markup") Keyboard replyMarkup, Callback<SendResponse> callback) {
        return botApi.sendMessage(chatId, text, disableWebPagePreview, replyToMessageId, replyMarkup, callback);
    }

    @Override
    public Observable<SendResponse> sendMessageRx(@Field("chat_id") Integer chatId, @Field("text") String text, @Field("disable_web_page_preview") Boolean disableWebPagePreview, @Field("reply_to_message_id") Integer replyToMessageId, @Field("reply_markup") Keyboard replyMarkup) {
        return botApi.sendMessageRx(chatId, text, disableWebPagePreview, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse forwardMessage(@Field("chat_id") Integer chatId, @Field("from_chat_id") Integer fromChatId, @Field("message_id") Integer messageId) {
        return botApi.forwardMessage(chatId, fromChatId, messageId);
    }

    @Override
    public SendResponse sendPhoto(@Part("chat_id") Integer chatId, @Part("photo") String photo, @Part("caption") String caption, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendPhoto(chatId, photo, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendPhoto(@Part("chat_id") Integer chatId, @Part("photo") InputFile photo, @Part("caption") String caption, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendPhoto(chatId, photo, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendPhoto(@Part("chat_id") Integer chatId, @Part("photo") InputFileBytes photo, @Part("caption") String caption, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendPhoto(chatId, photo, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendAudio(@Part("chat_id") Integer chatId, @Part("audio") String audio, @Part("duration") Integer duration, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendAudio(chatId, audio, duration, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendAudio(@Part("chat_id") Integer chatId, @Part("audio") InputFile audio, @Part("duration") Integer duration, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendAudio(chatId, audio, duration, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendAudio(@Part("chat_id") Integer chatId, @Part("audio") InputFileBytes audio, @Part("duration") Integer duration, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendAudio(chatId, audio, duration, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendDocument(@Part("chat_id") Integer chatId, @Part("document") String document, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendDocument(chatId, document, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendDocument(@Part("chat_id") Integer chatId, @Part("document") InputFile document, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendDocument(chatId, document, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendDocument(@Part("chat_id") Integer chatId, @Part("document") InputFileBytes document, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendDocument(chatId, document, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendSticker(@Part("chat_id") Integer chatId, @Part("sticker") String sticker, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendSticker(chatId, sticker, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendSticker(@Part("chat_id") Integer chatId, @Part("sticker") InputFile sticker, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendSticker(chatId, sticker, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendSticker(@Part("chat_id") Integer chatId, @Part("sticker") InputFileBytes sticker, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendSticker(chatId, sticker, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendVideo(@Part("chat_id") Integer chatId, @Part("video") String video, @Part("duration") Integer duration, @Part("caption") String caption, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendVideo(chatId, video, duration, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendVideo(@Part("chat_id") Integer chatId, @Part("video") InputFile video, @Part("duration") Integer duration, @Part("caption") String caption, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendVideo(chatId, video, duration, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendVideo(@Part("chat_id") Integer chatId, @Part("video") InputFileBytes video, @Part("duration") Integer duration, @Part("caption") String caption, @Part("reply_to_message_id") Integer replyToMessageId, @Part("reply_markup") Keyboard replyMarkup) {
        return botApi.sendVideo(chatId, video, duration, caption, replyToMessageId, replyMarkup);
    }

    @Override
    public SendResponse sendLocation(@Field("chat_id") Integer chatId, @Field("latitude") Float latitude, @Field("longitude") Float longitude, @Field("reply_to_message_id") Integer replyToMessageId, @Field("reply_markup") Keyboard replyMarkup) {
        return botApi.sendLocation(chatId, latitude, longitude, replyToMessageId, replyMarkup);
    }

    @Override
    public SendChatActionResponse sendChatAction(@Field("chat_id") Integer chatId, @Field("action") String action) {
        return botApi.sendChatAction(chatId, action);
    }

    @Override
    public GetUserProfilePhotos getUserProfilePhotos(@Query("user_id") Integer userId, @Query("offset") Integer offset, @Query("limit") Integer limit) {
        return botApi.getUserProfilePhotos(userId, offset, limit);
    }

    @Override
    public GetUpdatesResponse getUpdates(@Query("offset") Integer offset, @Query("limit") Integer limit, @Query("timeout") Integer timeout) {
        return botApi.getUpdates(offset, limit, timeout);
    }

    @Override
    public SetWebhookResponse setWebhook(@Field("url") String url) {
        return botApi.setWebhook(url);
    }

    @Override
    public GetFileResponse getFile(@Query("file_id") String fileId) {
        return botApi.getFile(fileId);
    }
}

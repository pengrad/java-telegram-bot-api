package com.pengrad.telegrambot;

import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.*;

/**
 * stas
 * 5/1/16.
 */
@Deprecated
public abstract class OldTelegramBot {

    private final FileApi fileApi;

    OldTelegramBot(FileApi file) {
        this.fileApi = file;
    }

    abstract public <T extends BaseRequest, R extends BaseResponse> R execute(BaseRequest<T, R> request);

    @Deprecated
    public GetFileResponse getFile(String fileId) {
        return execute(new GetFile(fileId));
    }

    @Deprecated
    public String getFullFilePath(String fileId) {
        GetFileResponse fileResponse = execute(new GetFile(fileId));
        if (!fileResponse.isOk() || fileResponse.file() == null) {
            return null;
        }
        return fileApi.getFullFilePath(fileResponse.file().filePath());
    }

    @Deprecated
    public GetMeResponse getMe() {
        return execute(new GetMe());
    }

    @Deprecated
    public BaseResponse sendChatAction(Object chatId, ChatAction action) {
        return execute(new SendChatAction(chatId, action.name()));
    }

    @Deprecated
    public SendResponse sendMessage(Object chatId, String text) {
        return execute(new SendMessage(chatId, text));
    }

    @Deprecated
    public SendResponse sendMessage(Object chatId, String text, ParseMode parseMode, Boolean disableWebPagePreview, Integer replyToMessageId, Keyboard replyMarkup) {
        SendMessage request = new SendMessage(chatId, text);
        if (parseMode != null) request.parseMode(parseMode);
        if (disableWebPagePreview != null) request.disableWebPagePreview(disableWebPagePreview);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return execute(request);
    }

    @Deprecated
    public SendResponse forwardMessage(Object chatId, Object fromChatId, Integer messageId) {
        return execute(new ForwardMessage(chatId, fromChatId, messageId));
    }

    @Deprecated
    public SendResponse sendPhoto(Object chatId, String photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendPhoto(new SendPhoto(chatId, photo), caption, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendPhoto(Object chatId, InputFile photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendPhoto(new SendPhoto(chatId, photo.getFile()), caption, replyToMessageId, replyMarkup);
    }

    @Deprecated
    public SendResponse sendPhoto(Object chatId, InputFileBytes photo, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendPhoto(new SendPhoto(chatId, photo.getBytes()), caption, replyToMessageId, replyMarkup);
    }

    private SendResponse sendPhoto(SendPhoto request, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        if (caption != null) request.caption(caption);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return execute(request);
    }

    @Deprecated
    public SendResponse sendAudio(Object chatId, String audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendAudio(new SendAudio(chatId, audio), duration, performer, title, replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendAudio(Object chatId, InputFile audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendAudio(new SendAudio(chatId, audio.getFile()), duration, performer, title, replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendAudio(Object chatId, InputFileBytes audio, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendAudio(new SendAudio(chatId, audio.getBytes()), duration, performer, title, replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendAudio(SendAudio request, Integer duration, String performer, String title, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        if (duration != null) request.duration(duration);
        if (performer != null) request.performer(performer);
        if (title != null) request.title(title);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return execute(request);
    }

    @Deprecated
    public SendResponse sendDocument(Object chatId, String document, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendDocument(new SendDocument(chatId, document), replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendDocument(Object chatId, InputFile document, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendDocument(new SendDocument(chatId, document.getFile()), replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendDocument(Object chatId, InputFileBytes document, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendDocument(new SendDocument(chatId, document.getBytes()), replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendDocument(SendDocument request, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return execute(request);
    }

    @Deprecated
    public SendResponse sendSticker(Object chatId, String sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendSticker(new SendSticker(chatId, sticker), replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendSticker(Object chatId, InputFile sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendSticker(new SendSticker(chatId, sticker.getFile()), replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendSticker(Object chatId, InputFileBytes sticker, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendSticker(new SendSticker(chatId, sticker.getBytes()), replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendSticker(SendSticker request, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return execute(request);
    }

    @Deprecated
    public SendResponse sendVideo(Object chatId, String video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVideo(new SendVideo(chatId, video), duration, caption, replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendVideo(Object chatId, InputFile video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVideo(new SendVideo(chatId, video.getFile()), duration, caption, replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendVideo(Object chatId, InputFileBytes video, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVideo(new SendVideo(chatId, video.getBytes()), duration, caption, replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendVideo(SendVideo request, Integer duration, String caption, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        if (duration != null) request.duration(duration);
        if (caption != null) request.caption(caption);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return execute(request);
    }

    @Deprecated
    public SendResponse sendVoice(Object chatId, String voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVoice(new SendVoice(chatId, voice), duration, replyToMessageId, replyMarkup, false);
    }

    @Deprecated
    public SendResponse sendVoice(Object chatId, InputFile voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVoice(new SendVoice(chatId, voice.getFile()), duration, replyToMessageId, replyMarkup, true);
    }

    @Deprecated
    public SendResponse sendVoice(Object chatId, InputFileBytes voice, Integer duration, Integer replyToMessageId, Keyboard replyMarkup) {
        return sendVoice(new SendVoice(chatId, voice.getBytes()), duration, replyToMessageId, replyMarkup, true);
    }

    private SendResponse sendVoice(SendVoice request, Integer duration, Integer replyToMessageId, Keyboard replyMarkup, boolean isMultipart) {
        if (duration != null) request.duration(duration);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return execute(request);
    }

    @Deprecated
    public SendResponse sendLocation(Object chatId, Float latitude, Float longitude, Integer replyToMessageId, Keyboard replyMarkup) {
        SendLocation request = new SendLocation(chatId, latitude, longitude);
        if (replyToMessageId != null) request.replyToMessageId(replyToMessageId);
        if (replyMarkup != null) request.replyMarkup(replyMarkup);
        return execute(request);
    }

    @Deprecated
    public GetUserProfilePhotosResponse getUserProfilePhotos(Integer userId, Integer offset, Integer limit) {
        GetUserProfilePhotos request = new GetUserProfilePhotos(userId);
        if (offset != null) request.offset(offset);
        if (limit != null) request.limit(limit);
        return execute(request);
    }

    @Deprecated
    public GetUpdatesResponse getUpdates(Integer offset, Integer limit, Integer timeout) {
        GetUpdates request = new GetUpdates();
        if (offset != null) request.offset(offset);
        if (limit != null) request.limit(limit);
        if (timeout != null) request.timeout(timeout);
        return execute(request);
    }

    @Deprecated
    public BaseResponse setWebhook(String url) {
        SetWebhook request = new SetWebhook();
        if (url != null) request.url(url);
        return execute(request);
    }

    @Deprecated
    public BaseResponse setWebhook(String url, InputFile certificate) {
        SetWebhook request = new SetWebhook();
        if (url != null) request.url(url);
        if (certificate != null) request.certificate(certificate.getFile());
        return execute(request);
    }

    @Deprecated
    public BaseResponse setWebhook(String url, InputFileBytes certificate) {
        SetWebhook request = new SetWebhook();
        if (url != null) request.url(url);
        if (certificate != null) request.certificate(certificate.getBytes());
        return execute(request);
    }

    @Deprecated
    public BaseResponse answerInlineQuery(String inlineQueryId, InlineQueryResult... results) {
        return answerInlineQuery(inlineQueryId, results, null, null, null);
    }

    @Deprecated
    public BaseResponse answerInlineQuery(String inlineQueryId, InlineQueryResult[] results, Integer cacheTime, Boolean isPersonal, String nextOffset) {
        AnswerInlineQuery request = new AnswerInlineQuery(inlineQueryId, results);
        if (cacheTime != null) request.cacheTime(cacheTime);
        if (isPersonal != null) request.isPersonal(isPersonal);
        if (nextOffset != null) request.nextOffset(nextOffset);
        return execute(request);
    }

}

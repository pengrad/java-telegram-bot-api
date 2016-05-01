package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

/**
 * stas
 * 5/1/16.
 */
public class SendVideo extends AbstractMultipartRequest<SendVideo> {

    public SendVideo(TelegramApi api, Object chatId, Object video, boolean isMultipart) {
        super(api, chatId, isMultipart);
        add("video", video);
    }

    public SendVideo duration(int duration) {
        return add("duration", duration);
    }

    public SendVideo width(int width) {
        return add("width", width);
    }

    public SendVideo height(int height) {
        return add("height", height);
    }

    public SendVideo caption(String caption) {
        return add("caption", caption);
    }

    @Override
    public String getMethod() {
        return "sendVideo";
    }

    @Override
    public String getFileName() {
        return ContentTypes.VIDEO_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.VIDEO_MIME_TYPE;
    }
}

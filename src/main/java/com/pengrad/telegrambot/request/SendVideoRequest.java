package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

/**
 * stas
 * 5/1/16.
 */
public class SendVideoRequest extends AbstractMultipartRequest<SendVideoRequest> {

    public SendVideoRequest(TelegramApi api, Object chatId, Object video, boolean isMultipart) {
        super(api, chatId, isMultipart);
        add("video", video);
    }

    public SendVideoRequest duration(int duration) {
        return add("duration", duration);
    }

    public SendVideoRequest width(int width) {
        return add("width", width);
    }

    public SendVideoRequest height(int height) {
        return add("height", height);
    }

    public SendVideoRequest caption(String caption) {
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

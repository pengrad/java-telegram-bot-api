package com.pengrad.telegrambot.request;

/**
 * stas
 * 5/1/16.
 */
public class SendVideo extends AbstractMultipartRequest<SendVideo> {

    public SendVideo(Object chatId, Object video, boolean isMultipart) {
        super(chatId, isMultipart);
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
    public String getFileName() {
        return ContentTypes.VIDEO_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.VIDEO_MIME_TYPE;
    }
}

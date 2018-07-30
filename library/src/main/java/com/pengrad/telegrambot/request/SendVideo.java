package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.ParseMode;

import java.io.File;

/**
 * stas
 * 5/1/16.
 */
public class SendVideo extends AbstractMultipartRequest<SendVideo> {

    public SendVideo(Object chatId, String video) {
        super(chatId, video);
    }

    public SendVideo(Object chatId, File video) {
        super(chatId, video);
    }

    public SendVideo(Object chatId, byte[] video) {
        super(chatId, video);
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

    public SendVideo thumb(byte[] thumb) {
        return super.thumb(thumb);
    }

    public SendVideo thumb(File thumb) {
        return super.thumb(thumb);
    }

    public SendVideo caption(String caption) {
        return add("caption", caption);
    }

    public SendVideo parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendVideo supportsStreaming(boolean supportsStreaming) {
        return add("supports_streaming", supportsStreaming);
    }

    @Override
    protected String getFileParamName() {
        return "video";
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.VIDEO_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.VIDEO_MIME_TYPE;
    }
}

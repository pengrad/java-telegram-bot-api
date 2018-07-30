package com.pengrad.telegrambot.request;

import java.io.File;

/**
 * Stas Parshin
 * 24 May 2017
 */
public class SendVideoNote extends AbstractMultipartRequest<SendVideoNote> {

    public SendVideoNote(Object chatId, String videoNote) {
        super(chatId, videoNote);
    }

    public SendVideoNote(Object chatId, File videoNote) {
        super(chatId, videoNote);
    }

    public SendVideoNote(Object chatId, byte[] videoNote) {
        super(chatId, videoNote);
    }

    public SendVideoNote duration(int duration) {
        return add("duration", duration);
    }

    public SendVideoNote length(int length) {
        return add("length", length);
    }

    public SendVideoNote thumb(byte[] thumb) {
        return super.thumb(thumb);
    }

    public SendVideoNote thumb(File thumb) {
        return super.thumb(thumb);
    }

    @Override
    protected String getFileParamName() {
        return "video_note";
    }

    @Override
    public String getContentType() {
        return ContentTypes.VIDEO_MIME_TYPE;
    }

    @Override
    protected String getDefaultFileName() {
        return ContentTypes.VIDEO_FILE_NAME;
    }
}

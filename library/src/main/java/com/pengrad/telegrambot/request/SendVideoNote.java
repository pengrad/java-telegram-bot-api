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

    /**
     * @deprecated Use thumbnail instead
     */
    @Deprecated 
    public SendVideoNote thumb(byte[] thumb) {
        return thumbnail(thumb);
    }

    /**
     * @deprecated Use thumbnail instead
     */
    @Deprecated 
    public SendVideoNote thumb(File thumb) {
        return thumbnail(thumb);
    }

    public SendVideoNote thumbnail(byte[] thumbnail) {
        return super.thumbnail(thumbnail);
    }

    public SendVideoNote thumbnail(File thumbnail) {
        return super.thumbnail(thumbnail);
    }

    @Override
    protected String getFileParamName() {
        return "video_note";
    }

    @Override
    public String getDefaultContentType() {
        return ContentTypes.VIDEO_MIME_TYPE;
    }

    @Override
    protected String getDefaultFileName() {
        return ContentTypes.VIDEO_FILE_NAME;
    }
}

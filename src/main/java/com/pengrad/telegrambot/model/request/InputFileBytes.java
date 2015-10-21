package com.pengrad.telegrambot.model.request;

import retrofit.mime.TypedByteArray;

/**
 * stas
 * 8/11/15.
 */
public class InputFileBytes extends TypedByteArray {

    // everything becomes jpeg
    public static final String PHOTO_MIME_TYPE = "image/jpeg";
    // or mpeg
    public static final String AUDIO_MIME_TYPE = "audio/mpeg";
    // or mp4
    public static final String VIDEO_MIME_TYPE = "video/mp4";

    // necessary for telegram
    public static final String PHOTO_FILE_NAME = "file.jpg";
    public static final String AUDIO_FILE_NAME = "file.mp3";
    public static final String VIDEO_FILE_NAME = "file.mp4";

    public static InputFileBytes photo(byte[] bytes) {
        return new InputFileBytes(PHOTO_MIME_TYPE, bytes, PHOTO_FILE_NAME);
    }

    public static InputFileBytes audio(byte[] bytes) {
        return new InputFileBytes(AUDIO_MIME_TYPE, bytes, AUDIO_FILE_NAME);
    }

    public static InputFileBytes video(byte[] bytes) {
        return new InputFileBytes(VIDEO_MIME_TYPE, bytes, VIDEO_FILE_NAME);
    }

    private String fileName;

    public InputFileBytes(String mimeType, byte[] bytes, String fileName) {
        super(mimeType, bytes);
        this.fileName = fileName;
    }

    @Override
    public String fileName() {
        return fileName;
    }
}

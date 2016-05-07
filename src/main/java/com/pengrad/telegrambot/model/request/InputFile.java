package com.pengrad.telegrambot.model.request;

import java.io.File;

/**
 * stas
 * 8/11/15.
 */
public class InputFile {

    public static InputFile photo(File file) {
        return new InputFile(InputFileBytes.PHOTO_MIME_TYPE, file);
    }

    public static InputFile audio(File file) {
        return new InputFile(InputFileBytes.AUDIO_MIME_TYPE, file);
    }

    public static InputFile video(File file) {
        return new InputFile(InputFileBytes.VIDEO_MIME_TYPE, file);
    }

    public static InputFile voice(File file) {
        return new InputFile(InputFileBytes.VOICE_MIME_TYPE, file);
    }

    private final File file;

    public InputFile(String mimeType, File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}

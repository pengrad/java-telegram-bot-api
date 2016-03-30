package com.pengrad.telegrambot.model.request;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

import java.io.File;
import java.io.IOException;

/**
 * stas
 * 8/11/15.
 */
public class InputFile extends RequestBody {

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

    private RequestBody delegate;

    public InputFile(String mimeType, File file) {
        delegate = RequestBody.create(MediaType.parse(mimeType), file);
    }

    @Override
    public MediaType contentType() {
        return delegate.contentType();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        delegate.writeTo(sink);
    }

    @Override
    public long contentLength() throws IOException {
        return delegate.contentLength();
    }
}

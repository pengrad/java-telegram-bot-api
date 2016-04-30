package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.model.request.InputFile;
import com.pengrad.telegrambot.response.SendResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * stas
 * 5/1/16.
 */
public class SendPhotoRequest extends BaseRequest<SendResponse> {

    private final MultipartBody.Builder builder;

    public SendPhotoRequest(TelegramApi api, Object chatId, InputFile photo) {
        super(api, SendResponse.class);
        builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("chat_id", String.valueOf(chatId))
                .addFormDataPart("photo", "test.jpg", photo);
    }

    public SendPhotoRequest caption(String caption) {
        builder.addFormDataPart("caption", caption);
        return this;
    }

    @Override
    public String getMethod() {
        return "sendPhoto";
    }

    @Override
    public RequestBody getRequestBody() {
        return builder.build();
    }
}

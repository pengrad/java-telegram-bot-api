package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.GetMyDescriptionResponse;

public class GetMyDescription extends BaseRequest<GetMyDescription, GetMyDescriptionResponse> {

    public GetMyDescription(TelegramBotClient api) {
        super(api, GetMyDescriptionResponse.class);
    }

    /**
     * 
     * @param languageCode A two-letter ISO 639-1 language code or an empty string
     * @return
     */
    public GetMyDescription languageCode(String languageCode) {
        add("language_code", languageCode);
        return this;
    }
}

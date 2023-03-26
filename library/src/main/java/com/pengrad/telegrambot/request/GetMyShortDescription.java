package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetMyShortDescriptionResponse;

public class GetMyShortDescription extends BaseRequest<GetMyShortDescription, GetMyShortDescriptionResponse> {

    public GetMyShortDescription() {
        super(GetMyShortDescriptionResponse.class);
    }

    /**
     * 
     * @param languageCode A two-letter ISO 639-1 language code or an empty string
     * @return
     */
    public GetMyShortDescription languageCode(String languageCode) {
        add("language_code", languageCode);
        return this;
    }
}

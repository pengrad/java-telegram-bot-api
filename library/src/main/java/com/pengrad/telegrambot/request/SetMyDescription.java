package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class SetMyDescription extends BaseRequest<SetMyDescription, BaseResponse> {

    public SetMyDescription() {
        super(BaseResponse.class);
    }
    
    /**
     * 
     * @param description New bot description; 0-512 characters. Pass an empty string to remove the dedicated description for the given language.
     * @return
     */
    public SetMyDescription description(String description) {
        add("description", description);
        return this;
    }

    /**
     * 
     * @param languageCode A two-letter ISO 639-1 language code. If empty, the description will be applied to all users for whose language there is no dedicated description.
     * @return
     */
    public SetMyDescription languageCode(String languageCode) {
        add("language_code", languageCode);
        return this;
    }

}

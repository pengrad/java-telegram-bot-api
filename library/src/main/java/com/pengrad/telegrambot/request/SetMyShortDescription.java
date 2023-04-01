package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class SetMyShortDescription extends BaseRequest<SetMyDescription, BaseResponse> {

    public SetMyShortDescription() {
        super(BaseResponse.class);
    }
    
    /**
     * 
     * @param shortDescription New short description for the bot; 0-120 characters. Pass an empty string to remove the dedicated short description for the given language.
     * @return
     */
    public SetMyShortDescription description(String shortDescription) {
        add("short_description", shortDescription);
        return this;
    }

    /**
     * 
     * @param languageCode A two-letter ISO 639-1 language code. If empty, the description will be applied to all users for whose language there is no dedicated description.
     * @return
     */
    public SetMyShortDescription languageCode(String languageCode) {
        add("language_code", languageCode);
        return this;
    }

}

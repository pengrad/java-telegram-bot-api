package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.botcommandscope.BotCommandScope;
import com.pengrad.telegrambot.response.BaseResponse;

public class DeleteMyCommands extends BaseRequest<DeleteMyCommands, BaseResponse> {
    public DeleteMyCommands() {
        super(BaseResponse.class);
    }

    public DeleteMyCommands scope(BotCommandScope scope) {
        this.add("scope", scope);
        return this;
    }

    public DeleteMyCommands languageCode(String languageCode) {
        this.add("language_code", languageCode);
        return this;
    }
}

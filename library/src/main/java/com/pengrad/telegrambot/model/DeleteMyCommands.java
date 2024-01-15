package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.botcommandscope.BotCommandScope;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * @deprecated Use com.pengrad.telegrambot.request.DeleteMyCommands instead
 */
@Deprecated
public class DeleteMyCommands extends BaseRequest<DeleteMyCommands, BaseResponse> {

    public DeleteMyCommands() {
        super(BaseResponse.class);
    }

    /**
     * 
     * @param scope An object that extends the BotCommandScope class. For example: new BotCommandScopeAllPrivateChats()
     * @return
     */
    public DeleteMyCommands scope(BotCommandScope scope) {
        add("scope", scope);
        return this;
    }

    /**
     * 
     * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
     * @return
     */
    public DeleteMyCommands languageCode(String languageCode) {
        add("language_code", languageCode);
        return this;
    }
}

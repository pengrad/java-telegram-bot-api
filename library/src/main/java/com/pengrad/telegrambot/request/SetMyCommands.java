package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.botcommandscope.BotCommandScope;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class SetMyCommands extends BaseRequest<SetMyCommands, BaseResponse> {

    public SetMyCommands(BotCommand... commands) {
        super(BaseResponse.class);
        add("commands", commands);
    }

    
    /**
     * 
     * @param scope An object that extends the BotCommandScope class. For example: new BotCommandScopeAllPrivateChats()
     * @return
     */
    public SetMyCommands scope(BotCommandScope scope) {
        add("scope", scope);
        return this;
    }

    /**
     * 
     * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
     * @return
     */
    public SetMyCommands languageCode(String languageCode) {
        add("language_code", languageCode);
        return this;
    }
}

package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.botcommandscope.BotCommandScope;
import com.pengrad.telegrambot.response.GetMyCommandsResponse;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class GetMyCommands extends BaseRequest<GetMyCommands, GetMyCommandsResponse> {

    public GetMyCommands() {
        super(GetMyCommandsResponse.class);
    }

    /**
     * 
     * @param scope An object that extends the BotCommandScope class. For example: new BotCommandScopeAllPrivateChats()
     * @return
     */
    public GetMyCommands scope(BotCommandScope scope) {
        add("scope", scope);
        return this;
    }

    /**
     * 
     * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
     * @return
     */
    public GetMyCommands languageCode(String languageCode) {
        add("language_code", languageCode);
        return this;
    }
}

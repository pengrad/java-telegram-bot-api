package com.pengrad.telegrambot.model.botcommandscope;

public class BotCommandsScopeChat extends BotCommandScope {
    
    private Object chat_id;

    /**
     * 
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     */
    public BotCommandsScopeChat(Object chatId) {
        this.type = "chat";
        this.chat_id = chatId;
    }

}

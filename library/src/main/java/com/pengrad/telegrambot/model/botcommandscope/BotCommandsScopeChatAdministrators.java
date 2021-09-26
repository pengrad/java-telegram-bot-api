package com.pengrad.telegrambot.model.botcommandscope;

public class BotCommandsScopeChatAdministrators extends BotCommandScope {
    
    private Object chat_id;

    /**
     * 
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     */
    public BotCommandsScopeChatAdministrators(Object chatId) {
        this.type = "chat_administrators";
        this.chat_id = chatId;
    }

}

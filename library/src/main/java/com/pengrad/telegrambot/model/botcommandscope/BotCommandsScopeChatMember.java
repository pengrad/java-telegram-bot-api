package com.pengrad.telegrambot.model.botcommandscope;

public class BotCommandsScopeChatMember extends BotCommandScope {
    
    private Object chat_id;
    private long user_id;

    /**
     * 
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param userId Unique identifier of the target user
     */
    public BotCommandsScopeChatMember(Object chatId, long userId) {
        this.type = "chat_member";
        this.chat_id = chatId;
        this.user_id = userId;
    }

}

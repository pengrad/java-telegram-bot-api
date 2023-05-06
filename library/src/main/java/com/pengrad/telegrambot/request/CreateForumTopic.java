package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.CreateForumTopicResponse;

public class CreateForumTopic extends BaseRequest<CreateForumTopic, CreateForumTopicResponse> {

    /**
     * @deprecated use constructor with Long for future compatibility
     */
    @Deprecated
    public CreateForumTopic(TelegramBotClient api, Integer chatId, String name) {
        this(api, chatId.toString(), name);
    }

    public CreateForumTopic(TelegramBotClient api, Long chatId, String name) {
        this(api, chatId.toString(), name);
    }

    public CreateForumTopic(TelegramBotClient api, String chatId, String name) {
        super(api, CreateForumTopicResponse.class);
        add("chat_id", chatId);
        add("name", name);
    }

    public CreateForumTopic iconColor(Integer iconColor) {
        add("icon_color", iconColor);
        return this;
    }

    public CreateForumTopic iconCustomEmojiId(String iconCustomEmojiId) {
        add("icon_custom_emoji_id", iconCustomEmojiId);
        return this;
    }
}

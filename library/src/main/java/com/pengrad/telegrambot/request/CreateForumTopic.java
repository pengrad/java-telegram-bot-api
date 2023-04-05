package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.CreateForumTopicResponse;

public class CreateForumTopic extends BaseRequest<CreateForumTopic, CreateForumTopicResponse> {

    /**
     * @deprecated use constructor with Long for future compatibility
     */
    @Deprecated
    public CreateForumTopic(Integer chatId, String name) {
        this(chatId.toString(), name);
    }

    public CreateForumTopic(Long chatId, String name) {
        this(chatId.toString(), name);
    }

    public CreateForumTopic(String chatId, String name) {
        super(CreateForumTopicResponse.class);
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

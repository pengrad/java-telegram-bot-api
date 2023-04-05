package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class EditForumTopic extends BaseRequest<EditForumTopic, BaseResponse> {

    /**
     * @deprecated use constructor with Long for future compatibility
     */
    @Deprecated
    public EditForumTopic(Integer chatId, Integer messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public EditForumTopic(Long chatId, Integer messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public EditForumTopic(String chatId, Integer messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }

    /**
     * @deprecated use constructor with Long for future compatibility
     */
    @Deprecated
    public EditForumTopic(Integer chatId, Integer messageThreadId, String name, String iconCustomEmojiId) {
        this(chatId.toString(), messageThreadId, name, iconCustomEmojiId);
    }

    public EditForumTopic(Long chatId, Integer messageThreadId, String name, String iconCustomEmojiId) {
        this(chatId.toString(), messageThreadId, name, iconCustomEmojiId);
    }

    public EditForumTopic(String chatId, Integer messageThreadId, String name, String iconCustomEmojiId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
        add("name", name);
        add("icon_custom_emoji_id", iconCustomEmojiId);
    }


    public EditForumTopic name(String name) {
        add("name", name);
        return this;
    }

    public EditForumTopic iconCustomEmojiId(String icon_custom_emoji_id) {
        add("icon_custom_emoji_id", icon_custom_emoji_id);
        return this;
    }

}

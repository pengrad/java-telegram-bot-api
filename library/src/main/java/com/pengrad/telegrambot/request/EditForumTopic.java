package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class EditForumTopic extends BaseRequest<EditForumTopic, BaseResponse> {

    public EditForumTopic(Long chatId,
                          Integer messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }

    public EditForumTopic(String chatId,
                          Integer messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }

    public EditForumTopic(Long chatId,
                          Integer messageThreadId,
                          String name,
                          String iconCustomEmojiId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
        add("name", name);
        add("icon_custom_emoji_id", iconCustomEmojiId);
    }

    public EditForumTopic(String chatId,
                          Integer messageThreadId,
                          String name,
                          String iconCustomEmojiId) {
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

package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class EditForumTopic extends BaseRequest<EditForumTopic, BaseResponse> {
    public EditForumTopic(Integer chatId,
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
}

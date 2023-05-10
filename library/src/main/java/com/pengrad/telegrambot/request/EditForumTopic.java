package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

public class EditForumTopic extends BaseRequest<EditForumTopic, BaseResponse> {

    /**
     * @deprecated use constructor with Long for future compatibility
     */
    @Deprecated
    public EditForumTopic(TelegramBotClient api, Integer chatId, Integer messageThreadId) {
        this(api, chatId.toString(), messageThreadId);
    }

    public EditForumTopic(TelegramBotClient api, Long chatId, Integer messageThreadId) {
        this(api, chatId.toString(), messageThreadId);
    }

    public EditForumTopic(TelegramBotClient api, String chatId, Integer messageThreadId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }

    /**
     * @deprecated use constructor with Long for future compatibility
     */
    @Deprecated
    public EditForumTopic(TelegramBotClient api, Integer chatId, Integer messageThreadId, String name, String iconCustomEmojiId) {
        this(api, chatId.toString(), messageThreadId, name, iconCustomEmojiId);
    }

    public EditForumTopic(TelegramBotClient api, Long chatId, Integer messageThreadId, String name, String iconCustomEmojiId) {
        this(api, chatId.toString(), messageThreadId, name, iconCustomEmojiId);
    }

    public EditForumTopic(TelegramBotClient api, String chatId, Integer messageThreadId, String name, String iconCustomEmojiId) {
        super(api, BaseResponse.class);
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

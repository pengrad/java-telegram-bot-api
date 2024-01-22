package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.MessageIdsResponse;

public class ForwardMessages extends BaseRequest<ForwardMessages, MessageIdsResponse> {

    public ForwardMessages(Object chatId, Object fromChatId, int[] messageIds) {
        super(MessageIdsResponse.class);
        add("chat_id", chatId).add("from_chat_id", fromChatId).add("message_ids", messageIds);
    }

    public ForwardMessages messageThreadId(Integer messageThreadId) {
        return add("message_thread_id", messageThreadId);
    }
    public ForwardMessages disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }
    public ForwardMessages protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

}

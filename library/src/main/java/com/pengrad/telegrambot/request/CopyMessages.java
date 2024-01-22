package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.MessageIdsResponse;


public class CopyMessages extends BaseRequest<CopyMessages, MessageIdsResponse> {

    public CopyMessages(Object chatId, Object fromChatId, int[] messageIds) {
        super(MessageIdsResponse.class);
        add("chat_id", chatId).add("from_chat_id", fromChatId).add("message_ids", messageIds);
    }

    public CopyMessages messageThreadId(Integer messageThreadId) {
        return add("message_thread_id", messageThreadId);
    }

    public CopyMessages removeCaption(boolean removeCaption) {
        return add("remove_caption", removeCaption);
    }

    public CopyMessages disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }
    public CopyMessages protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

}

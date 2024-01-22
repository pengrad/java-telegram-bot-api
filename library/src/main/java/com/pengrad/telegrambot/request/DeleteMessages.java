package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class DeleteMessages extends BaseRequest<DeleteMessages, BaseResponse> {

    public DeleteMessages(Object chatId, int[] messageIds) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("message_ids", messageIds);
    }
}

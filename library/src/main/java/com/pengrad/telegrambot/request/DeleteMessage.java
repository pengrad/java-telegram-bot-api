package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.DeleteResponse;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * Alireza Hanifi
 * 20 May 2017
 */
public class DeleteMessage extends BaseRequest<DeleteMessage, BaseResponse> {

    public DeleteMessage(Object chatId, int messageId) {
        super(DeleteResponse.class);
        add("chat_id", chatId).add("message_id", messageId);
    }

}

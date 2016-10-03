package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class SetGameScore extends BaseRequest<SetGameScore, BaseResponse> {

    public SetGameScore(int userId, int score, Object chatId, int messageId) {
        super(SendResponse.class);
        add("user_id", userId).add("score", score).add("chat_id", chatId).add("message_id", messageId);
    }

    public SetGameScore(int userId, int score, String inlineMessageId) {
        super(SendResponse.class);
        add("user_id", userId).add("score", score).add("inline_message_id", inlineMessageId);
    }

    public SetGameScore editMessage(boolean edit_message) {
        return add("edit_message", edit_message);
    }

}

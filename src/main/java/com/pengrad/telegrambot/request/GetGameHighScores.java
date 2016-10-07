package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetGameHighScoresResponse;

/**
 * Stas Parshin
 * 04 October 2016
 */
public class GetGameHighScores extends BaseRequest<GetGameHighScores, GetGameHighScoresResponse> {

    public GetGameHighScores(int userId, Object chatId, int messageId) {
        super(GetGameHighScoresResponse.class);
        add("user_id", userId).add("chat_id", chatId).add("message_id", messageId);
    }

    public GetGameHighScores(int userId, String inlineMessageId) {
        super(GetGameHighScoresResponse.class);
        add("user_id", userId).add("inline_message_id", inlineMessageId);
    }

}

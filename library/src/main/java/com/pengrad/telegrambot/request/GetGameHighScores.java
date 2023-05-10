package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.GetGameHighScoresResponse;

/**
 * Stas Parshin
 * 04 October 2016
 */
public class GetGameHighScores extends BaseRequest<GetGameHighScores, GetGameHighScoresResponse> {

    public GetGameHighScores(TelegramBotClient api, long userId, Object chatId, int messageId) {
        super(api, GetGameHighScoresResponse.class);
        add("user_id", userId).add("chat_id", chatId).add("message_id", messageId);
    }

    public GetGameHighScores(TelegramBotClient api, long userId, String inlineMessageId) {
        super(api, GetGameHighScoresResponse.class);
        add("user_id", userId).add("inline_message_id", inlineMessageId);
    }

}

package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.reaction.ReactionType;
import com.pengrad.telegrambot.response.BaseResponse;

public class SetMessageReaction extends BaseRequest<SetMessageReaction, BaseResponse> {

    public SetMessageReaction(Object chatId, int messageId, ReactionType... reactions) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("message_id", messageId).add("reaction", reactions);
    }

    public SetMessageReaction(Object chatId, int messageId) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("message_id", messageId);
    }

    public SetMessageReaction isBig(boolean isBig) {
        return add("is_big", isBig);
    }
}

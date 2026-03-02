package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class SetChatMemberTag extends BaseRequest<SetChatMemberTag, BaseResponse> {

    public SetChatMemberTag(Object chatId, long userId) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("user_id", userId);
    }

    public SetChatMemberTag tag(String tag) {
        return add("tag", tag);
    }
}

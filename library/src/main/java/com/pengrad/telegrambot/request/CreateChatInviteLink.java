package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.ChatInviteLinkResponse;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class CreateChatInviteLink extends BaseRequest<CreateChatInviteLink, ChatInviteLinkResponse> {

    public CreateChatInviteLink(Object chatId) {
        super(ChatInviteLinkResponse.class);
        add("chat_id", chatId);
    }

    public CreateChatInviteLink expireDate(Integer expireDate) {
        return add("expire_date", expireDate);
    }

    public CreateChatInviteLink memberLimit(Integer memberLimit) {
        return add("member_limit", memberLimit);
    }
}

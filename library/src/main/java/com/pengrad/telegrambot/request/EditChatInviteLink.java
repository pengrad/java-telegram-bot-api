package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.ChatInviteLinkResponse;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class EditChatInviteLink extends BaseRequest<EditChatInviteLink, ChatInviteLinkResponse> {

    public EditChatInviteLink(Object chatId, String inviteLink) {
        super(ChatInviteLinkResponse.class);
        add("chat_id", chatId);
        add("invite_link", inviteLink);
    }

    public EditChatInviteLink expireDate(Integer expireDate) {
        return add("expire_date", expireDate);
    }

    public EditChatInviteLink memberLimit(Integer memberLimit) {
        return add("member_limit", memberLimit);
    }
}

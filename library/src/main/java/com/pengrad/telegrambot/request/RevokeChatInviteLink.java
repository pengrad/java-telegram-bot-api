package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.ChatInviteLinkResponse;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class RevokeChatInviteLink extends BaseRequest<RevokeChatInviteLink, ChatInviteLinkResponse> {

    public RevokeChatInviteLink(Object chatId, String inviteLink) {
        super(ChatInviteLinkResponse.class);
        add("chat_id", chatId);
        add("invite_link", inviteLink);
    }
}

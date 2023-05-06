package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.ChatInviteLinkResponse;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class EditChatInviteLink extends BaseRequest<EditChatInviteLink, ChatInviteLinkResponse> {

    public EditChatInviteLink(TelegramBotClient api, Object chatId, String inviteLink) {
        super(api, ChatInviteLinkResponse.class);
        add("chat_id", chatId);
        add("invite_link", inviteLink);
    }

    /**
     * 
     * @param name Invite link name; 0-32 characters
     * @return
     */
    public EditChatInviteLink name(String name) {
        return add("name", name);
    }

    public EditChatInviteLink expireDate(Integer expireDate) {
        return add("expire_date", expireDate);
    }

    public EditChatInviteLink memberLimit(Integer memberLimit) {
        return add("member_limit", memberLimit);
    }

    /**
     * 
     * @param createsJoinRequest True, if users joining the chat via the link need to be approved by chat administrators. If True, member_limit can't be specified
     * @return
     */
    public EditChatInviteLink createsJoinRequest(Boolean createsJoinRequest) {
        return add("creates_join_request", createsJoinRequest);
    }
}

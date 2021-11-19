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

    /**
     * 
     * @param name Invite link name; 0-32 characters
     */
    public CreateChatInviteLink name(String name) {
        return add("name", name);
    }

    public CreateChatInviteLink expireDate(Integer expireDate) {
        return add("expire_date", expireDate);
    }

    public CreateChatInviteLink memberLimit(Integer memberLimit) {
        return add("member_limit", memberLimit);
    }

    /**
     * 
     * @param createsJoinRequest True, if users joining the chat via the link need to be approved by chat administrators. If True, member_limit can't be specified
     */
    public CreateChatInviteLink createsJoinRequest(Boolean createsJoinRequest) {
        return add("creates_join_request", createsJoinRequest);
    }
}

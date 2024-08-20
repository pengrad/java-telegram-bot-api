package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.ChatInviteLinkResponse;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class EditChatSubscriptionInviteLink extends BaseRequest<EditChatSubscriptionInviteLink, ChatInviteLinkResponse> {

    /**
     * Edit a subscription invite link created by the bot
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param inviteLink The invite link to edit
     */
    public EditChatSubscriptionInviteLink(Object chatId, String inviteLink) {
        super(ChatInviteLinkResponse.class);
        add("chat_id", chatId);
        add("invite_link", inviteLink);
    }

    /**
     * 
     * @param name Invite link name; 0-32 characters
     * @return
     */
    public EditChatSubscriptionInviteLink name(String name) {
        return add("name", name);
    }

}

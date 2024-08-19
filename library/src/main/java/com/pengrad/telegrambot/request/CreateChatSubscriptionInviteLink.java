package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.ChatInviteLinkResponse;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class CreateChatSubscriptionInviteLink extends BaseRequest<CreateChatSubscriptionInviteLink, ChatInviteLinkResponse> {

    /**
     * Create a subscription invite link for a channel chat.
     *
     * @param chatId Unique identifier for the target channel chat or username of the target channel (in the format @channelusername)
     * @param subscriptionPeriod The number of seconds the subscription will be active for before the next payment. Currently, it must always be 2592000 (30 days).
     * @param subscriptionPrice The amount of Telegram Stars a user must pay initially and after each subsequent subscription period to be a member of the chat; 1-2500
     */
    public CreateChatSubscriptionInviteLink(Object chatId, Integer subscriptionPeriod, Integer subscriptionPrice) {
        super(ChatInviteLinkResponse.class);
        add("chat_id", chatId);
        add("subscription_period", subscriptionPeriod);
        add("subscription_price", subscriptionPrice);
    }

    /**
     * 
     * @param name Invite link name; 0-32 characters
     */
    public CreateChatSubscriptionInviteLink name(String name) {
        return add("name", name);
    }


}

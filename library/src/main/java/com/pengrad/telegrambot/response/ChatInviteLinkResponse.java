package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.ChatInviteLink;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class ChatInviteLinkResponse extends BaseResponse {

    private ChatInviteLink result;

    public ChatInviteLink chatInviteLink() {
        return result;
    }

    @Override
    public String toString() {
        return "ChatInviteLinkResponse{" +
                "result=" + result +
                '}';
    }
}

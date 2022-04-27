package com.pengrad.telegrambot.response;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class SentWebAppMessageResponse extends BaseResponse {
   
    private String inline_message_id;

    public String inlineMessageId() {
        return inline_message_id;
    }

    @Override
    public String toString() {
        return "SentWebAppMessageResponse{" +
                "inline_message_id=" + inline_message_id +
                '}';
    }

}

package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.ChatPermissions;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class RestrictChatMember extends BaseRequest<RestrictChatMember, BaseResponse> {

    public RestrictChatMember(Object chatId, long userId) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("user_id", userId);
    }

    public RestrictChatMember(Object chatId, long userId, ChatPermissions permissions) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("user_id", userId).add("permissions", permissions);
    }

    public RestrictChatMember untilDate(int untilDate) {
        return add("until_date", untilDate);
    }

    public RestrictChatMember canSendMessages(boolean canSendMessages) {
        return add("can_send_messages", canSendMessages);
    }

    public RestrictChatMember canSendMediaMessages(boolean canSendMediaMessages) {
        return add("can_send_media_messages", canSendMediaMessages);
    }

    public RestrictChatMember canSendOtherMessages(boolean canSendOtherMessages) {
        return add("can_send_other_messages", canSendOtherMessages);
    }

    public RestrictChatMember canAddWebPagePreviews(boolean canAddWebPagePreviews) {
        return add("can_add_web_page_previews", canAddWebPagePreviews);
    }
}

package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * stas
 * 5/2/16.
 * 
 * @deprecated from BOT API v5.3 you should use BanChatMember instead
 */
@Deprecated
public class KickChatMember extends BaseRequest<KickChatMember, BaseResponse> {

    public KickChatMember(TelegramBotClient api, Object chatId, long userId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("user_id", userId);
    }

    public KickChatMember untilDate(int untilDate) {
        return add("until_date", untilDate);
    }

    public KickChatMember revokeMessages(boolean revokeMessages) {
        return add("revoke_messages", revokeMessages);
    }
}

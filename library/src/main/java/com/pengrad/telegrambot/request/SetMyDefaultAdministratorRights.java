package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.ChatAdministratorRights;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class SetMyDefaultAdministratorRights extends BaseRequest<SetMyDefaultAdministratorRights, BaseResponse> {
 
    public SetMyDefaultAdministratorRights(TelegramBotClient api) {
        super(api, BaseResponse.class);
    }

    public SetMyDefaultAdministratorRights rights(ChatAdministratorRights chatAdministratorRights) {
        return add("rights", chatAdministratorRights);
    }

    public SetMyDefaultAdministratorRights forChannels(boolean forChannels) {
        return add("for_channels", forChannels);
    }

}

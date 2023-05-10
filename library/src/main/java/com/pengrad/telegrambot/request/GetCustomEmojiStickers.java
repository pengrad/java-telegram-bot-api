package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.GetCustomEmojiStickersResponse;

/**
 * Mirco Ianese
 * 16 Aug 2022
 */
public class GetCustomEmojiStickers extends BaseRequest<GetCustomEmojiStickers, GetCustomEmojiStickersResponse> {

    public GetCustomEmojiStickers(TelegramBotClient api, String... custom_emoji_ids) {
        super(api, GetCustomEmojiStickersResponse.class);
        add("custom_emoji_ids", custom_emoji_ids);
    }
}

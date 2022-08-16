package com.pengrad.telegrambot.response;

import java.util.Arrays;

import com.pengrad.telegrambot.model.Sticker;

/**
 * Mirco Ianese
 * 16 Aug 2022
 */
public class GetCustomEmojiStickersResponse extends BaseResponse {

    private Sticker[] result;

    public Sticker[] result() {
        return result;
    }

    @Override
    public String toString() {
        return "GetCustomEmojiStickersResponse{" +
                "result=" + Arrays.toString(result) +
                '}';
    }
}

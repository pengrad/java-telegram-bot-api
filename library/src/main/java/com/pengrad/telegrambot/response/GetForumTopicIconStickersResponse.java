package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Sticker;

import java.util.Arrays;

public class GetForumTopicIconStickersResponse extends BaseResponse {
    private Sticker[] result;

    GetForumTopicIconStickersResponse() {

    }

    public Sticker[] stickers() {
        return result;
    }

    @Override
    public String toString() {
        return "GetForumTopicIconStickersResponse{" +
                "result=" + Arrays.toString(result) +
                '}';
    }
}

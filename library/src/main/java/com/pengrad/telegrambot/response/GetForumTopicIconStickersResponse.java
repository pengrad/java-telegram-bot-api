package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Sticker;

import java.util.List;

public class GetForumTopicIconStickersResponse extends BaseResponse {
    private List<Sticker> result;

    GetForumTopicIconStickersResponse() {

    }

    public List<Sticker> stickers() {
        return result;
    }

    @Override
    public String toString() {
        return "GetForumTopicIconStickersResponse{" +
                "result=" + result +
                '}';
    }
}

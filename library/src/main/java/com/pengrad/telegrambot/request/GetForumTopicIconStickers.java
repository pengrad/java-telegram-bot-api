package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetForumTopicIconStickersResponse;

public class GetForumTopicIconStickers extends BaseRequest<GetForumTopicIconStickers, GetForumTopicIconStickersResponse> {
    public GetForumTopicIconStickers() {
        super(GetForumTopicIconStickersResponse.class);
    }
}

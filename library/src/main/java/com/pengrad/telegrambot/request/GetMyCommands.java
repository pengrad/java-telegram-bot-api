package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetMyCommandsResponse;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class GetMyCommands extends BaseRequest<GetMyCommands, GetMyCommandsResponse> {

    public GetMyCommands() {
        super(GetMyCommandsResponse.class);
    }
}

package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InlineQueryResult;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SentWebAppMessageResponse;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class AnswerWebAppQuery extends BaseRequest<AnswerWebAppQuery, SentWebAppMessageResponse> {

    public AnswerWebAppQuery(String web_app_query_id, InlineQueryResult<?> result) {
        super(SentWebAppMessageResponse.class);
        add("web_app_query_id", web_app_query_id).add("result", result);
    }


}

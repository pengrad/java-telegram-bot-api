package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InlineQueryResult;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * stas
 * 5/2/16.
 */
public class AnswerInlineQuery extends BaseRequest<AnswerInlineQuery, BaseResponse> {

    public AnswerInlineQuery(String inlineQueryId, InlineQueryResult<?>... results) {
        super(BaseResponse.class);
        add("inline_query_id", inlineQueryId).add("results", results);
    }

    public AnswerInlineQuery cacheTime(int cacheTime) {
        return add("cache_time", cacheTime);
    }

    public AnswerInlineQuery isPersonal(boolean isPersonal) {
        return add("is_personal", isPersonal);
    }

    public AnswerInlineQuery nextOffset(String nextOffset) {
        return add("next_offset", nextOffset);
    }

    public AnswerInlineQuery switchPmText(String switchPmText) {
        return add("switch_pm_text", switchPmText);
    }

    public AnswerInlineQuery switchPmParameter(String switchPmParameter) {
        return add("switch_pm_parameter", switchPmParameter);
    }

}

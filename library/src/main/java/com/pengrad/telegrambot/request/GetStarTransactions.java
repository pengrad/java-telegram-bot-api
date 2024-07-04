package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetStarTransactionsResponse;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetStarTransactions extends BaseRequest<GetStarTransactions, GetStarTransactionsResponse> {

    public GetStarTransactions() {
        super(GetStarTransactionsResponse.class);
    }

    public GetStarTransactions offset(Integer offset) {
        add("offset", offset);
        return this;
    }

    public GetStarTransactions limit(Integer limit) {
        add("limit", limit);
        return this;
    }

}

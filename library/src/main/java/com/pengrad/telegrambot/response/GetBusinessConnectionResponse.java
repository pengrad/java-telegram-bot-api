package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.business.BusinessConnection;

import java.util.Objects;

public class GetBusinessConnectionResponse extends BaseResponse {

    private BusinessConnection result;

    public BusinessConnection businessConnection() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBusinessConnectionResponse)) return false;
        GetBusinessConnectionResponse that = (GetBusinessConnectionResponse) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "GetBusinessConnectionResponse{" +
            "result=" + result +
            '}';
    }
}

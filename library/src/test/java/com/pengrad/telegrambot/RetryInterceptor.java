package com.pengrad.telegrambot;

import com.google.gson.*;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.response.*;

import java.io.*;

import okhttp3.*;

/**
 * Stas Parshin
 * 26 January 2020
 */
public class RetryInterceptor implements Interceptor {

    private final int defaultSleepMillis;
    private final Gson gson = new Gson();

    public RetryInterceptor() {
        this(1000);
    }

    public RetryInterceptor(int defaultSleepMillis) {
        this.defaultSleepMillis = defaultSleepMillis;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Exception exception = null;
        int retries = 3;
        while (retries-- > 0) {
            try {
                Response response = chain.proceed(request);
                if (response.isSuccessful()) {
                    return response;
                } else if (response.code() != 429) {
                    return response;
                } else {
                    BaseResponse baseResponse = gson.fromJson(response.body().string(), BaseResponse.class);
                    ResponseParameters params = baseResponse.parameters();
                    int sleepTimeMillis;
                    if (params != null && params.retryAfter() != null) {
                        sleepTimeMillis = params.retryAfter() * 1000;
                    } else {
                        sleepTimeMillis = defaultSleepMillis;
                    }
                    System.err.println("++++ response " + response.code() + " sleep for " + sleepTimeMillis + " ms");
                    Thread.sleep(sleepTimeMillis);
                }
            } catch (Exception e) {
                exception = e;
                System.err.println("++++ exception " + e.getMessage());
                e.printStackTrace(System.err);
                try {
                    Thread.sleep(defaultSleepMillis);
                } catch (InterruptedException ignored) {}
            }
        }
        if (exception instanceof IOException) throw (IOException) exception;
        else if (exception != null) throw new RuntimeException(exception);
        else throw new RuntimeException("empty exception");
    }
}

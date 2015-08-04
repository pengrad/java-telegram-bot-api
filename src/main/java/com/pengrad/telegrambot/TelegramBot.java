package com.pengrad.telegrambot;

import com.google.gson.JsonObject;
import com.pengrad.telegrambot.request.SendMessageRequest;
import com.pengrad.telegrambot.response.GetMeResponse;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * stas
 * 8/4/15.
 */
public interface TelegramBot {

    @GET("/getMe")
    GetMeResponse getMe();

    @POST("/sendMessage")
    JsonObject sendMessage(@Body SendMessageRequest sendMessageRequest);
}
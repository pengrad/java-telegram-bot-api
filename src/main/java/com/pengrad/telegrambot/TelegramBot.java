package com.pengrad.telegrambot;

import com.pengrad.telegrambot.request.SendMessageRequest;
import com.pengrad.telegrambot.request.SendPhotoRequest;
import com.pengrad.telegrambot.response.GetMeResponse;
import com.pengrad.telegrambot.response.SendResponse;
import retrofit.http.*;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedFile;

/**
 * stas
 * 8/4/15.
 */
public interface TelegramBot {

    @GET("/getMe")
    GetMeResponse getMe();

    @POST("/sendMessage")
    SendResponse sendMessage(@Body SendMessageRequest sendMessageRequest);

    @POST("/sendPhoto")
    SendResponse sendPhotoAsFileId(@Body SendPhotoRequest sendPhotoRequest);

    @Multipart
    @POST("/sendPhoto")
    SendResponse sendPhoto(@Part("chat_id") Integer chat_id, @Part("photo") TypedFile photo);

    @Multipart
    @POST("/sendPhoto")
    SendResponse sendPhotoAsBytes(@Part("chat_id") Integer chat_id, @Part("photo") TypedByteArray photo);
}
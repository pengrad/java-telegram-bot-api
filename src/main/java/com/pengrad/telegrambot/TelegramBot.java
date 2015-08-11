package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Keyboard;
import com.pengrad.telegrambot.response.GetMeResponse;
import com.pengrad.telegrambot.response.SendResponse;
import retrofit.Callback;
import retrofit.http.*;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedFile;
import rx.Observable;


/**
 * stas
 * 8/4/15.
 */
public interface TelegramBot {

    @GET("/getMe")
    GetMeResponse getMe();

    @GET("/getMe")
    void getMe(Callback<GetMeResponse> callback);

    @GET("/getMe")
    Observable<GetMeResponse> getMeRx();

    @POST("/sendMessage")
    @FormUrlEncoded
    SendResponse sendMessage(
            @Field("chat_id") Integer chatId,
            @Field("text") String text,
            @Field("disable_web_page_preview") Boolean disableWebPagePreview,
            @Field("reply_to_message_id") Integer replyToMessageId,
            @Field("reply_markup") Keyboard replyMarkup);

    @POST("/sendMessage")
    @FormUrlEncoded
    SendResponse sendMessage(
            @Field("chat_id") Integer chatId,
            @Field("text") String text,
            @Field("disable_web_page_preview") Boolean disableWebPagePreview,
            @Field("reply_to_message_id") Integer replyToMessageId,
            @Field("reply_markup") Keyboard replyMarkup,
            Callback<SendResponse> callback);

    @POST("/sendMessage")
    @FormUrlEncoded
    Observable<SendResponse> sendMessageRx(
            @Field("chat_id") Integer chatId,
            @Field("text") String text,
            @Field("disable_web_page_preview") Boolean disableWebPagePreview,
            @Field("reply_to_message_id") Integer replyToMessageId,
            @Field("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendPhoto")
    SendResponse sendPhoto(
            @Part("chat_id") Integer chat_id,
            @Part("photo") String photo,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendPhoto")
    SendResponse sendPhoto(
            @Part("chat_id") Integer chat_id,
            @Part("photo") TypedFile photo,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendPhoto")
    SendResponse sendPhoto(
            @Part("chat_id") Integer chat_id,
            @Part("photo") TypedByteArray photo,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);
}
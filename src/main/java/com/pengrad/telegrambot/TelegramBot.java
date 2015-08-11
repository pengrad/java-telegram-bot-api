package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.InputFile;
import com.pengrad.telegrambot.model.InputFileBytes;
import com.pengrad.telegrambot.model.Keyboard;
import com.pengrad.telegrambot.response.GetMeResponse;
import com.pengrad.telegrambot.response.SendResponse;
import retrofit.Callback;
import retrofit.http.*;
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


    @POST("/forwardMessage")
    @FormUrlEncoded
    SendResponse forwardMessage(
            @Field("chat_id") Integer chatId,
            @Field("from_chat_id") Integer fromChatId,
            @Field("message_id") Integer messageId);


    @Multipart
    @POST("/sendPhoto")
    SendResponse sendPhoto(
            @Part("chat_id") Integer chatId,
            @Part("photo") String photo,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendPhoto")
    SendResponse sendPhoto(
            @Part("chat_id") Integer chatId,
            @Part("photo") InputFile photo,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendPhoto")
    SendResponse sendPhoto(
            @Part("chat_id") Integer chatId,
            @Part("photo") InputFileBytes photo,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);


    @Multipart
    @POST("/sendAudio")
    SendResponse sendAudio(
            @Part("chat_id") Integer chatId,
            @Part("audio") String audio,
            @Part("duration") Integer duration,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendAudio")
    SendResponse sendAudio(
            @Part("chat_id") Integer chatId,
            @Part("audio") InputFile audio,
            @Part("duration") Integer duration,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendAudio")
    SendResponse sendAudio(
            @Part("chat_id") Integer chatId,
            @Part("audio") InputFileBytes audio,
            @Part("duration") Integer duration,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);


    @Multipart
    @POST("/sendDocument")
    SendResponse sendDocument(
            @Part("chat_id") Integer chatId,
            @Part("document") String document,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendDocument")
    SendResponse sendDocument(
            @Part("chat_id") Integer chatId,
            @Part("document") InputFile document,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendDocument")
    SendResponse sendDocument(
            @Part("chat_id") Integer chatId,
            @Part("document") InputFileBytes document,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);


    @Multipart
    @POST("/sendVideo")
    SendResponse sendVideo(
            @Part("chat_id") Integer chatId,
            @Part("video") String video,
            @Part("duration") Integer duration,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendVideo")
    SendResponse sendVideo(
            @Part("chat_id") Integer chatId,
            @Part("video") InputFile video,
            @Part("duration") Integer duration,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("/sendVideo")
    SendResponse sendVideo(
            @Part("chat_id") Integer chatId,
            @Part("video") InputFileBytes video,
            @Part("duration") Integer duration,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);
}
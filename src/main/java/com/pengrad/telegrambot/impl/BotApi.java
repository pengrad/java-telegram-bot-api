package com.pengrad.telegrambot.impl;

import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.model.request.InputFile;
import com.pengrad.telegrambot.model.request.InputFileBytes;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.response.*;
import okhttp3.RequestBody;
import retrofit2.http.*;


/**
 * stas
 * 8/4/15.
 */
public interface BotApi {

    @POST("forwardMessage")
    SendResponse forwardMessage(@Body RequestBody body);

    @Multipart
    @POST("sendAudio")
    SendResponse sendAudio(
            @Part("chat_id") String chatId,
            @Part("audio") String audio,
            @Part("duration") Integer duration,
            @Part("performer") String performer,
            @Part("title") String title,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendAudio")
    SendResponse sendAudio(
            @Part("chat_id") String chatId,
            @Part("audio") InputFile audio,
            @Part("duration") Integer duration,
            @Part("performer") String performer,
            @Part("title") String title,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendAudio")
    SendResponse sendAudio(
            @Part("chat_id") String chatId,
            @Part("audio") InputFileBytes audio,
            @Part("duration") Integer duration,
            @Part("performer") String performer,
            @Part("title") String title,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);


    @Multipart
    @POST("sendDocument")
    SendResponse sendDocument(
            @Part("chat_id") String chatId,
            @Part("document") String document,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendDocument")
    SendResponse sendDocument(
            @Part("chat_id") String chatId,
            @Part("document") InputFile document,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendDocument")
    SendResponse sendDocument(
            @Part("chat_id") String chatId,
            @Part("document") InputFileBytes document,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);


    @Multipart
    @POST("sendSticker")
    SendResponse sendSticker(
            @Part("chat_id") String chatId,
            @Part("sticker") String sticker,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendSticker")
    SendResponse sendSticker(
            @Part("chat_id") String chatId,
            @Part("sticker") InputFile sticker,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendSticker")
    SendResponse sendSticker(
            @Part("chat_id") String chatId,
            @Part("sticker") InputFileBytes sticker,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);


    @Multipart
    @POST("sendVideo")
    SendResponse sendVideo(
            @Part("chat_id") String chatId,
            @Part("video") String video,
            @Part("duration") Integer duration,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendVideo")
    SendResponse sendVideo(
            @Part("chat_id") String chatId,
            @Part("video") InputFile video,
            @Part("duration") Integer duration,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendVideo")
    SendResponse sendVideo(
            @Part("chat_id") String chatId,
            @Part("video") InputFileBytes video,
            @Part("duration") Integer duration,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);


    @Multipart
    @POST("sendVoice")
    SendResponse sendVoice(
            @Part("chat_id") String chatId,
            @Part("voice") String voice,
            @Part("duration") Integer duration,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendVoice")
    SendResponse sendVoice(
            @Part("chat_id") String chatId,
            @Part("voice") InputFile voice,
            @Part("duration") Integer duration,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendVoice")
    SendResponse sendVoice(
            @Part("chat_id") String chatId,
            @Part("voice") InputFileBytes voice,
            @Part("duration") Integer duration,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);


    @FormUrlEncoded
    @POST("sendLocation")
    SendResponse sendLocation(
            @Field("chat_id") String chatId,
            @Field("latitude") Float latitude,
            @Field("longitude") Float longitude,
            @Field("reply_to_message_id") Integer replyToMessageId,
            @Field("reply_markup") Keyboard replyMarkup);


    @FormUrlEncoded
    @POST("sendChatAction")
    SendChatActionResponse sendChatAction(
            @Field("chat_id") String chatId,
            @Field("action") ChatAction action);


    @GET("getUserProfilePhotos")
    GetUserProfilePhotosResponse getUserProfilePhotos(
            @Query("user_id") Integer userId,
            @Query("offset") Integer offset,
            @Query("limit") Integer limit);


    @GET("getUpdates")
    GetUpdatesResponse getUpdates(
            @Query("offset") Integer offset,
            @Query("limit") Integer limit,
            @Query("timeout") Integer timeout);


    @FormUrlEncoded
    @POST("setWebhook")
    BaseResponse setWebhook(@Field("url") String url);

    @Multipart
    @POST("setWebhook")
    BaseResponse setWebhook(@Part("url") String url, @Part("certificate") InputFile certificate);

    @Multipart
    @POST("setWebhook")
    BaseResponse setWebhook(@Part("url") String url, @Part("certificate") InputFileBytes certificate);

    @GET("getFile")
    GetFileResponse getFile(@Query("file_id") String fileId);

    @FormUrlEncoded
    @POST("answerInlineQuery")
    BaseResponse answerInlineQuery(
            @Field("inline_query_id") String inlineQueryId,
            @Field("results") String results,
            @Field("cache_time") Integer cacheTime,
            @Field("is_personal") Boolean isPersonal,
            @Field("next_offset") String nextOffset);
}
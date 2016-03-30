package com.pengrad.telegrambot.impl;

import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.response.*;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.*;


/**
 * stas
 * 8/4/15.
 */
public interface BotApi {

    @GET("getMe")
    GetMeResponse getMe();


    @POST("sendMessage")
    @FormUrlEncoded
    SendResponse sendMessage(
            @Field("chat_id") String chatId,
            @Field("text") String text,
            @Field("parse_mode") ParseMode parse_mode,
            @Field("disable_web_page_preview") Boolean disableWebPagePreview,
            @Field("reply_to_message_id") Integer replyToMessageId,
            @Field("reply_markup") Keyboard replyMarkup);


    @POST("forwardMessage")
    @FormUrlEncoded
    SendResponse forwardMessage(
            @Field("chat_id") String chatId,
            @Field("from_chat_id") String fromChatId,
            @Field("message_id") Integer messageId);


    @Multipart
    @POST("sendPhoto")
    SendResponse sendPhoto(
            @Part("chat_id") String chatId,
            @Part("photo") String photo,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @Multipart
    @POST("sendPhoto")
    SendResponse sendPhoto(
            @Part("chat_id") RequestBody chatId,
            @Part MultipartBody.Part photo,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);

    @POST("sendPhoto")
    SendResponse sendPhoto(@Body RequestBody body);

    @Multipart
    @POST("sendPhoto")
    SendResponse sendPhoto(
            @Part("chat_id") String chatId,
            @Part("photo") InputFileBytes photo,
            @Part("caption") String caption,
            @Part("reply_to_message_id") Integer replyToMessageId,
            @Part("reply_markup") Keyboard replyMarkup);


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
    SetWebhookResponse setWebhook(@Field("url") String url);

    @Multipart
    @POST("setWebhook")
    SetWebhookResponse setWebhook(@Part("url") String url, @Part("certificate") InputFile certificate);

    @Multipart
    @POST("setWebhook")
    SetWebhookResponse setWebhook(@Part("url") String url, @Part("certificate") InputFileBytes certificate);

    @GET("getFile")
    GetFileResponse getFile(@Query("file_id") String fileId);

    @FormUrlEncoded
    @POST("answerInlineQuery")
    OkResponse answerInlineQuery(
            @Field("inline_query_id") String inlineQueryId,
            @Field("results") String results,
            @Field("cache_time") Integer cacheTime,
            @Field("is_personal") Boolean isPersonal,
            @Field("next_offset") String nextOffset);
}
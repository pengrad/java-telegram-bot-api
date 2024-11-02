package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.response.MessagesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.File;
import java.util.Map;

public class SendPaidMedia extends BaseRequest<SendPaidMedia, SendResponse> {

    private boolean isMultipart = false;

    public SendPaidMedia(Object chatId, Integer starCount, InputPaidMedia... media) {
        super(SendResponse.class);
        add("chat_id", chatId).add("star_count", starCount).add("media", media);

        for (InputPaidMedia m : media) {
            Map<String, Object> attachments = m.getAttachments();
            if (attachments != null && !attachments.isEmpty()) {
                addAll(attachments);
                isMultipart = true;
            }
            if (m.inputFile() != null) {
                add(m.getInputFileId(), m.inputFile());
                isMultipart = true;
            }
        }
    }

    @Override
    public boolean isMultipart() {
        return isMultipart;
    }

    public SendPaidMedia caption(String caption) {
        return add("caption", caption);
    }

    public SendPaidMedia parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendPaidMedia captionEntities(MessageEntity... entities) {
        return add("caption_entities", entities);
    }

    public SendPaidMedia showCaptionAboveMedia(boolean showCaptionAboveMedia) {
        return add("show_caption_above_media", showCaptionAboveMedia);
    }

    public SendPaidMedia disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public SendPaidMedia protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    public SendPaidMedia replyParameters(ReplyParameters replyParameters) {
        return add("reply_parameters", replyParameters);
    }

    public SendPaidMedia businessConnectionId(String businessConnectionId) {
        return add("business_connection_id", businessConnectionId);
    }

    public SendPaidMedia replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    public SendPaidMedia replyMarkup(ReplyKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    public SendPaidMedia replyMarkup(ReplyKeyboardRemove replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    public SendPaidMedia replyMarkup(ForceReply replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    public SendPaidMedia payload(String payload) {
        return add("payload", payload);
    }
  
    public SendPaidMedia allowPaidBroadcast(boolean allowPaidBroadcast) {
        return add("allow_paid_broadcast", allowPaidBroadcast);
    }

}

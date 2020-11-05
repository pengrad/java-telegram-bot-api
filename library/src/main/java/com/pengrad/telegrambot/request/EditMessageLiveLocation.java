package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * Stas Parshin
 * 11 October 2017
 */
public class EditMessageLiveLocation extends BaseRequest<EditMessageLiveLocation, BaseResponse> {

    public EditMessageLiveLocation(Object chatId, int messageId, float latitude, float longitude) {
        super(SendResponse.class);
        add("chat_id", chatId).add("message_id", messageId).add("latitude", latitude).add("longitude", longitude);
    }

    public EditMessageLiveLocation(String inlineMessageId, float latitude, float longitude) {
        super(BaseResponse.class);
        add("inline_message_id", inlineMessageId).add("latitude", latitude).add("longitude", longitude);
    }

    public EditMessageLiveLocation horizontalAccuracy(float horizontalAccuracy) {
        return add("horizontal_accuracy", horizontalAccuracy);
    }

    public EditMessageLiveLocation heading(int heading) {
        return add("heading", heading);
    }

    public EditMessageLiveLocation proximityAlertRadius(int proximityAlertRadius) {
        return add("proximity_alert_radius", proximityAlertRadius);
    }

    public EditMessageLiveLocation replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }
}

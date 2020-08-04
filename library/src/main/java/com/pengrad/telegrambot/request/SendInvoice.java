package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.LabeledPrice;

/**
 * Stas Parshin
 * 24 May 2017
 */
public class SendInvoice extends AbstractSendRequest<SendInvoice> {

    public SendInvoice(Integer chatId, String title, String description, String payload, String providerToken,
                       String startParameter, String currency, LabeledPrice... prices) {
        super(chatId);
        add("title", title).add("description", description).add("payload", payload).add("provider_token", providerToken)
                .add("start_parameter", startParameter).add("currency", currency).add("prices", prices);
    }

    public SendInvoice providerData(String providerData) {
        return add("provider_data", providerData);
    }

    public SendInvoice photoUrl(String photoUrl) {
        return add("photo_url", photoUrl);
    }

    public SendInvoice photoSize(Integer photoSize) {
        return add("photo_size", photoSize);
    }

    public SendInvoice photoWidth(Integer photoWidth) {
        return add("photo_width", photoWidth);
    }

    public SendInvoice photoHeight(Integer photoHeight) {
        return add("photo_height", photoHeight);
    }

    public SendInvoice needName(boolean needName) {
        return add("need_name", needName);
    }

    public SendInvoice needPhoneNumber(boolean needPhoneNumber) {
        return add("need_phone_number", needPhoneNumber);
    }

    public SendInvoice needEmail(boolean needEmail) {
        return add("need_email", needEmail);
    }

    public SendInvoice needShippingAddress(boolean needShippingAddress) {
        return add("need_shipping_address", needShippingAddress);
    }

    public SendInvoice isFlexible(boolean isFlexible) {
        return add("is_flexible", isFlexible);
    }
}

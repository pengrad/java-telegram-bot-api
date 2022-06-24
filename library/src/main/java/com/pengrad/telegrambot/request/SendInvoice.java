package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.LabeledPrice;

/**
 * Stas Parshin
 * 24 May 2017
 */
public class SendInvoice extends AbstractSendRequest<SendInvoice> {

    public SendInvoice(Long chatId, String title, String description, String payload, String providerToken,
                        String currency, LabeledPrice... prices) {
        super(chatId);
        add("title", title).add("description", description).add("payload", payload).add("provider_token", providerToken)
                .add("currency", currency).add("prices", prices);
    }

    // Backward compatibility: API 5.2, parameter "start_parameter" became optional
    public SendInvoice(Long chatId, String title, String description, String payload, String providerToken,
                       String startParameter, String currency, LabeledPrice... prices) {
        this(chatId, title, description, payload, providerToken, currency, prices);
        add("start_parameter", startParameter);
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

    public SendInvoice startParameter(String startParameter) {
        return add("start_parameter", startParameter);
    }

    /**
     * 
     * @param maxTipAmount The maximum accepted amount for tips in the smallest units of the currency
     */
    public SendInvoice maxTipAmount(int maxTipAmount) {
        return add("max_tip_amount", maxTipAmount);
    }

    /**
     * 
     * @param suggestedTipAmounts An array of suggested amounts of tip in the smallest units of the currency. At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed max_tip_amount.
     */
    public SendInvoice suggestedTipAmounts(Integer[] suggestedTipAmounts) {
        return add("suggested_tip_amounts", suggestedTipAmounts);
    }

    public SendInvoice sendEmailToProvider(boolean sendEmailToProvider) { return add("send_email_to_provider", sendEmailToProvider); }

    public SendInvoice sendPhoneNumberToProvider(boolean sendPhoneNumberToProvider) { return add("send_phone_number_to_provider", sendPhoneNumberToProvider); }

}

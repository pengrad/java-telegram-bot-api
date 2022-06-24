package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.LabeledPrice;
import com.pengrad.telegrambot.response.StringResponse;

/**
 * Mirco Ianese
 * 21 Jun 2022
 */
public class CreateInvoiceLink extends BaseRequest<CreateInvoiceLink, StringResponse> {

    public CreateInvoiceLink(String title, String description, String payload, String providerToken,
                             String currency, LabeledPrice... prices) {
        super(StringResponse.class);
        add("title", title).add("description", description).add("payload", payload)
                .add("provider_token", providerToken).add("currency", currency).add("prices", prices);
    }


    /**
     * @param maxTipAmount The maximum accepted amount for tips in the smallest units of the currency
     */
    public CreateInvoiceLink maxTipAmount(int maxTipAmount) {
        return add("max_tip_amount", maxTipAmount);
    }

    /**
     * @param suggestedTipAmounts An array of suggested amounts of tip in the smallest units of the currency. At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed max_tip_amount.
     */
    public CreateInvoiceLink suggestedTipAmounts(Integer[] suggestedTipAmounts) {
        return add("suggested_tip_amounts", suggestedTipAmounts);
    }

    public CreateInvoiceLink providerData(String providerData) {
        return add("provider_data", providerData);
    }

    public CreateInvoiceLink photoUrl(String photoUrl) {
        return add("photo_url", photoUrl);
    }

    public CreateInvoiceLink photoSize(Integer photoSize) {
        return add("photo_size", photoSize);
    }

    public CreateInvoiceLink photoWidth(Integer photoWidth) {
        return add("photo_width", photoWidth);
    }

    public CreateInvoiceLink photoHeight(Integer photoHeight) {
        return add("photo_height", photoHeight);
    }

    public CreateInvoiceLink needName(boolean needName) {
        return add("need_name", needName);
    }

    public CreateInvoiceLink needPhoneNumber(boolean needPhoneNumber) {
        return add("need_phone_number", needPhoneNumber);
    }

    public CreateInvoiceLink needEmail(boolean needEmail) {
        return add("need_email", needEmail);
    }

    public CreateInvoiceLink needShippingAddress(boolean needShippingAddress) {
        return add("need_shipping_address", needShippingAddress);
    }

    public CreateInvoiceLink sendEmailToProvider(boolean sendEmailToProvider) {
        return add("send_email_to_provider", sendEmailToProvider);
    }

    public CreateInvoiceLink sendPhoneNumberToProvider(boolean sendPhoneNumberToProvider) {
        return add("send_phone_number_to_provider", sendPhoneNumberToProvider);
    }

    public CreateInvoiceLink isFlexible(boolean isFlexible) {
        return add("is_flexible", isFlexible);
    }

}

package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

public class InputInvoiceMessageContent extends InputMessageContent implements Serializable {
    
    private final static long serialVersionUID = 0L;

    private String title;
    private String description;

    private String payload;
    private String provider_token;

    private String currency;
    private LabeledPrice[] prices;

    private Integer max_tip_amount;
    private Integer[] suggested_tip_amount;

    private String provider_data;

    private String photo_url;
    private Integer photo_size;
    private Integer photo_width;
    private Integer photo_height;

    private boolean need_name;
    private boolean need_phone_number;
    private boolean need_email;
    private boolean need_shipping_address;
    private boolean send_phone_number_to_provider;
    private boolean send_email_to_provider;

    private boolean is_flexible;


    public InputInvoiceMessageContent(String title, String description, String payload, String currency, LabeledPrice[] prices) {
        this.title = title;
        this.description = description;
        this.payload = payload;
        this.currency = currency;
        this.prices = prices;
    }

    /**
     * Backward compatibility: API 7.4, parameter "provider_token" became optional
     * @deprecated Use constrcutor without 'provider_token' instead
     */
    @Deprecated
    public InputInvoiceMessageContent(String title, String description, String payload, String providerToken, String currency, LabeledPrice[] prices) {
        this.title = title;
        this.description = description;
        this.payload = payload;
        this.provider_token = providerToken;
        this.currency = currency;
        this.prices = prices;
    }

    public InputInvoiceMessageContent providerToken(String providerToken) {
        this.provider_token = providerToken;
        return this;
    }

    public InputInvoiceMessageContent maxTipAmount(Integer maxTipAmount) {
        this.max_tip_amount = maxTipAmount;
        return this;
    }

    public InputInvoiceMessageContent suggestedTipAmount(Integer[] suggestedTipAmount) {
        this.suggested_tip_amount = suggestedTipAmount;
        return this;
    }

    public InputInvoiceMessageContent providerData(String providerData) {
        this.provider_data = providerData;
        return this;
    }

    public InputInvoiceMessageContent photoUrl(String photoUrl) {
        this.photo_url = photoUrl;
        return this;
    }

    public InputInvoiceMessageContent photoSize(Integer photoSize) {
        this.photo_size = photoSize;
        return this;
    }

    public InputInvoiceMessageContent photoWidth(Integer photoWidth) {
        this.photo_width = photoWidth;
        return this;
    }

    public InputInvoiceMessageContent photoHeight(Integer photoHeight) {
        this.photo_height = photoHeight;
        return this;
    }

    public InputInvoiceMessageContent needName(boolean needName) {
        this.need_name = needName;
        return this;
    }

    public InputInvoiceMessageContent needPhoneNumber(boolean needPhoneNumber) {
        this.need_phone_number = needPhoneNumber;
        return this;
    }

    public InputInvoiceMessageContent needEmail(boolean needEmail) {
        this.need_email = needEmail;
        return this;
    }

    public InputInvoiceMessageContent needShippingAddress(boolean needShippingAddress) {
        this.need_shipping_address = needShippingAddress;
        return this;
    }

    public InputInvoiceMessageContent sendPhoneNumberToProvider(boolean sendPhoneNumberToProvider) {
        this.send_phone_number_to_provider = sendPhoneNumberToProvider;
        return this;
    }

    public InputInvoiceMessageContent sendEmailToProvider(boolean sendEmailToProvider) {
        this.send_email_to_provider = sendEmailToProvider;
        return this;
    }

    public InputInvoiceMessageContent isFlexible(boolean isFlexible) {
        this.is_flexible = isFlexible;
        return this;
    }

}

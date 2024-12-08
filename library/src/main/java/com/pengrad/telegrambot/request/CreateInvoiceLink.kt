package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.request.LabeledPrice
import com.pengrad.telegrambot.response.StringResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class CreateInvoiceLink(
    title: String,
    description: String,
    payload: String,
    currency: String,
    vararg prices: LabeledPrice
) : KBaseRequest<CreateInvoiceLink, StringResponse>(StringResponse::class) {

    /**
     * Backward compatibility: API 7.4, parameter "provider_token" became optional
     * @deprecated Use constructor without 'provider_token' instead
     */
    @Deprecated("Use constructor without 'providerToken' parameter", ReplaceWith("CreateInvoiceLink(title, description, payload, currency, *prices)"))
    constructor(
        title: String,
        description: String,
        payload: String,
        providerToken: String,
        currency: String,
        vararg prices: LabeledPrice
    ) : this(title, description, payload, currency, *prices) {
        this.providerToken = providerToken
    }

    val title: String by requestParameter(title)
    val description: String by requestParameter(description)
    val payload: String by requestParameter(payload)
    val currency: String by requestParameter(currency)
    val prices: Array<LabeledPrice> by requestParameter(arrayOf(*prices))

    @set:JvmName("providerToken") var providerToken: String? by optionalRequestParameter(customParameterName = "provider_token")
    @set:JvmName("maxTipAmount") var maxTipAmount: Int? by optionalRequestParameter(customParameterName = "max_tip_amount")
    @set:JvmName("suggestedTipAmounts") var suggestedTipAmounts: Array<Int>? by optionalRequestParameter(customParameterName = "suggested_tip_amounts")
    @set:JvmName("providerData") var providerData: String? by optionalRequestParameter(customParameterName = "provider_data")
    @set:JvmName("photoUrl") var photoUrl: String? by optionalRequestParameter(customParameterName = "photo_url")
    @set:JvmName("photoSize") var photoSize: Int? by optionalRequestParameter(customParameterName = "photo_size")
    @set:JvmName("photoWidth") var photoWidth: Int? by optionalRequestParameter(customParameterName = "photo_width")
    @set:JvmName("photoHeight") var photoHeight: Int? by optionalRequestParameter(customParameterName = "photo_height")
    @set:JvmName("needName") var needName: Boolean? by optionalRequestParameter(customParameterName = "need_name")
    @set:JvmName("needPhoneNumber") var needPhoneNumber: Boolean? by optionalRequestParameter(customParameterName = "need_phone_number")
    @set:JvmName("needEmail") var needEmail: Boolean? by optionalRequestParameter(customParameterName = "need_email")
    @set:JvmName("needShippingAddress") var needShippingAddress: Boolean? by optionalRequestParameter(customParameterName = "need_shipping_address")
    @set:JvmName("sendEmailToProvider") var sendEmailToProvider: Boolean? by optionalRequestParameter(customParameterName = "send_email_to_provider")
    @set:JvmName("sendPhoneNumberToProvider") var sendPhoneNumberToProvider: Boolean? by optionalRequestParameter(customParameterName = "send_phone_number_to_provider")
    @set:JvmName("isFlexible") var isFlexible: Boolean? by optionalRequestParameter(customParameterName = "is_flexible")

}
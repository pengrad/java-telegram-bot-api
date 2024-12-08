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

    var providerToken: String? by optionalRequestParameter(customParameterName = "provider_token")
    var subscriptionPeriod: Int? by optionalRequestParameter(customParameterName = "subscription_period")
    var businessConnectionId: String? by optionalRequestParameter(customParameterName = "business_connection_id")
    var maxTipAmount: Int? by optionalRequestParameter(customParameterName = "max_tip_amount")
    var suggestedTipAmounts: Array<Int>? by optionalRequestParameter(customParameterName = "suggested_tip_amounts")
    var providerData: String? by optionalRequestParameter(customParameterName = "provider_data")
    var photoUrl: String? by optionalRequestParameter(customParameterName = "photo_url")
    var photoSize: Int? by optionalRequestParameter(customParameterName = "photo_size")
    var photoWidth: Int? by optionalRequestParameter(customParameterName = "photo_width")
    var photoHeight: Int? by optionalRequestParameter(customParameterName = "photo_height")
    var needName: Boolean? by optionalRequestParameter(customParameterName = "need_name")
    var needPhoneNumber: Boolean? by optionalRequestParameter(customParameterName = "need_phone_number")
    var needEmail: Boolean? by optionalRequestParameter(customParameterName = "need_email")
    var needShippingAddress: Boolean? by optionalRequestParameter(customParameterName = "need_shipping_address")
    var sendEmailToProvider: Boolean? by optionalRequestParameter(customParameterName = "send_email_to_provider")
    var sendPhoneNumberToProvider: Boolean? by optionalRequestParameter(customParameterName = "send_phone_number_to_provider")
    var isFlexible: Boolean? by optionalRequestParameter(customParameterName = "is_flexible")

    fun providerToken(providerToken: String) = apply { this.providerToken = providerToken }

    fun subscriptionPeriod(subscriptionPeriod: Int) = apply { this.subscriptionPeriod = subscriptionPeriod }

    fun businessConnectionId(businessConnectionId: String) = apply { this.businessConnectionId = businessConnectionId }

    fun maxTipAmount(maxTipAmount: Int) = apply { this.maxTipAmount = maxTipAmount }

    fun suggestedTipAmounts(suggestedTipAmounts: Array<Int>) = apply { this.suggestedTipAmounts = suggestedTipAmounts }

    fun providerData(providerData: String) = apply { this.providerData = providerData }

    fun photoUrl(photoUrl: String) = apply { this.photoUrl = photoUrl }

    fun photoSize(photoSize: Int) = apply { this.photoSize = photoSize }

    fun photoWidth(photoWidth: Int) = apply { this.photoWidth = photoWidth }

    fun photoHeight(photoHeight: Int) = apply { this.photoHeight = photoHeight }

    fun needName(needName: Boolean) = apply { this.needName = needName }

    fun needPhoneNumber(needPhoneNumber: Boolean) = apply { this.needPhoneNumber = needPhoneNumber }

    fun needEmail(needEmail: Boolean) = apply { this.needEmail = needEmail }

    fun needShippingAddress(needShippingAddress: Boolean) = apply { this.needShippingAddress = needShippingAddress }

    fun sendEmailToProvider(sendEmailToProvider: Boolean) = apply { this.sendEmailToProvider = sendEmailToProvider }

    fun sendPhoneNumberToProvider(sendPhoneNumberToProvider: Boolean) = apply { this.sendPhoneNumberToProvider = sendPhoneNumberToProvider }

    fun isFlexible(isFlexible: Boolean) = apply { this.isFlexible = isFlexible }

}
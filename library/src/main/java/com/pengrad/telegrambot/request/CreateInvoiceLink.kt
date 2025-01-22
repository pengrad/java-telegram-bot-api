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

    var providerToken: String? by optionalRequestParameter()
    var subscriptionPeriod: Int? by optionalRequestParameter()
    var businessConnectionId: String? by optionalRequestParameter()
    var maxTipAmount: Int? by optionalRequestParameter()
    var suggestedTipAmounts: Array<Int>? by optionalRequestParameter()
    var providerData: String? by optionalRequestParameter()
    var photoUrl: String? by optionalRequestParameter()
    var photoSize: Int? by optionalRequestParameter()
    var photoWidth: Int? by optionalRequestParameter()
    var photoHeight: Int? by optionalRequestParameter()
    var needName: Boolean? by optionalRequestParameter()
    var needPhoneNumber: Boolean? by optionalRequestParameter()
    var needEmail: Boolean? by optionalRequestParameter()
    var needShippingAddress: Boolean? by optionalRequestParameter()
    var sendEmailToProvider: Boolean? by optionalRequestParameter()
    var sendPhoneNumberToProvider: Boolean? by optionalRequestParameter()
    var isFlexible: Boolean? by optionalRequestParameter()

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
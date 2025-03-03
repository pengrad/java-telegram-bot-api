package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.request.LabeledPrice
import com.pengrad.telegrambot.utility.kotlin.checkDeprecatedConstructorParameters
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SendInvoice private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    title: String,
    description: String,
    payload: String,
    currency: String,
    prices: List<LabeledPrice>
) : KAbstractSendRequest<SendInvoice>(
    chatId = chatId,
    channelUsername = channelUsername,
) {

    constructor(
        chatId: Long,
        title: String,
        description: String,
        payload: String,
        currency: String,
        prices: List<LabeledPrice>
    ) : this(
        chatId = chatId,
        channelUsername = null,
        title =  title,
        description = description,
        payload = payload,
        currency = currency,
        prices = prices
    )

    constructor(
        channelUsername: String,
        title: String,
        description: String,
        payload: String,
        currency: String,
        prices: List<LabeledPrice>
    ) : this(
        chatId = null,
        channelUsername = channelUsername,
        title =  title,
        description = description,
        payload = payload,
        currency = currency,
        prices = prices
    )

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendInvoice(chatId, title, description, payload, currency, prices.toList())"))
    constructor(
        chatId: Any,
        title: String,
        description: String,
        payload: String,
        currency: String,
        vararg prices: LabeledPrice
    ) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        title =  title,
        description = description,
        payload = payload,
        currency = currency,
        prices = prices.toList()
    ) {
        checkDeprecatedConstructorParameters()
    }

    val title: String by requestParameter(title)
    val description: String by requestParameter(description)
    val payload: String by requestParameter(payload)
    val currency: String by requestParameter(currency)
    val prices: List<LabeledPrice> by requestParameter(prices)

    var providerToken: String? by optionalRequestParameter()
    var providerData: String? by optionalRequestParameter()

    var maxTipAmount: Int? by optionalRequestParameter()
    var suggestedTipAmounts: List<Int>? by optionalRequestParameter()

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
    var subscriptionPeriod: Int? by optionalRequestParameter()
    var startParameter: String? by optionalRequestParameter()

    fun providerToken(providerToken: String) = applySelf { this.providerToken = providerToken }

    fun providerData(providerData: String) = applySelf { this.providerData = providerData }

    fun maxTipAmount(maxTipAmount: Int) = applySelf { this.maxTipAmount = maxTipAmount }

    fun suggestedTipAmounts(suggestedTipAmounts: List<Int>) = applySelf { this.suggestedTipAmounts = suggestedTipAmounts }

    fun suggestedTipAmounts(suggestedTipAmounts: Array<Int>) = suggestedTipAmounts(suggestedTipAmounts.toList())

    fun suggestedTipAmounts(vararg suggestedTipAmounts: Int) = suggestedTipAmounts(suggestedTipAmounts.toList())

    fun photoUrl(photoUrl: String) = applySelf { this.photoUrl = photoUrl }

    fun photoSize(photoSize: Int) = applySelf { this.photoSize = photoSize }

    fun photoWidth(photoWidth: Int) = applySelf { this.photoWidth = photoWidth }

    fun photoHeight(photoHeight: Int) = applySelf { this.photoHeight = photoHeight }

    fun needName(needName: Boolean) = applySelf { this.needName = needName }

    fun needPhoneNumber(needPhoneNumber: Boolean) = applySelf { this.needPhoneNumber = needPhoneNumber }

    fun needEmail(needEmail: Boolean) = applySelf { this.needEmail = needEmail }

    fun needShippingAddress(needShippingAddress: Boolean) = applySelf { this.needShippingAddress = needShippingAddress }

    fun sendEmailToProvider(sendEmailToProvider: Boolean) = applySelf { this.sendEmailToProvider = sendEmailToProvider }

    fun sendPhoneNumberToProvider(sendPhoneNumberToProvider: Boolean) = applySelf { this.sendPhoneNumberToProvider = sendPhoneNumberToProvider }

    fun isFlexible(isFlexible: Boolean) = applySelf { this.isFlexible = isFlexible }

    fun startParameter(startParameter: String) = applySelf { this.startParameter = startParameter }

}
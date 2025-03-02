package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.utility.kotlin.checkDeprecatedConstructorParameters
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SendContact private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    phoneNumber: String,
    firstName: String
) : KAbstractSendRequest<SendContact>(
    chatId = chatId,
    channelUsername = channelUsername,
) {

    constructor(chatId: Long, phoneNumber: String, firstName: String) : this(
        chatId = chatId,
        channelUsername = null,
        phoneNumber = phoneNumber,
        firstName = firstName
    )

    constructor(channelUsername: String, phoneNumber: String, firstName: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        phoneNumber = phoneNumber,
        firstName = firstName
    )

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendContact(chatId, phoneNumber, firstName)"))
    constructor(chatId: Any, phoneNumber: String, firstName: String) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        phoneNumber = phoneNumber,
        firstName = firstName
    ) {
        checkDeprecatedConstructorParameters()
    }

    val phoneNumber: String by requestParameter(phoneNumber)
    val firstName: String by requestParameter(firstName)

    var lastName: String? by optionalRequestParameter()
    var vcard: String? by optionalRequestParameter()

    fun lastName(lastName: String) = apply { this.lastName = lastName }

    fun vcard(vcard: String) = apply { this.vcard = vcard }

}
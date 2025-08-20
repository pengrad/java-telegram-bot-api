package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SendGift private constructor(
    userId: Long? = null,
    chatId: Long? = null,
    channelUsername: String? = null,
    giftId: String,
) : KBaseRequest<SendGift, BaseResponse>(BaseResponse::class) {

    companion object {

        @JvmStatic
        fun fromUserId(userId: Long, giftId: String) =
            SendGift(
                userId = userId,
                giftId = giftId
            )

        @JvmStatic
        fun fromChatId(chatId: Long, giftId: String) =
            SendGift(
                chatId = chatId,
                giftId = giftId
            )

        @JvmStatic
        fun fromChannel(channelUsername: String, giftId: String) = SendGift(
            channelUsername = channelUsername,
            giftId = giftId
        )

        /**
         * Backwards compatibility to constructor with userId
         */
        @Deprecated("Use constructor(chatId, giftId) instead", ReplaceWith("SendGift(userId, giftId)"))
        operator fun invoke(userId: Long, giftId: String) =
            fromUserId(
                userId = userId,
                giftId = giftId
            )

    }

    constructor(chatId: Long, giftId: String) : this(
        userId = null,
        chatId = chatId,
        channelUsername = null,
        giftId = giftId
    )

    constructor(
        channelUsername: String,
        giftId: String
    ) : this(
        userId = null,
        chatId = null,
        channelUsername = channelUsername,
        giftId = giftId
    )

    val userId: Long? by optionalRequestParameter(userId)
    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")

    val giftId: String by requestParameter(giftId)

    var payForUpgrade: Boolean? by  optionalRequestParameter()

    var text: String? by optionalRequestParameter()
    var textParseMode: ParseMode? by optionalRequestParameter(valueMapper = { it?.name })
    var textEntities: Array<MessageEntity>? by optionalRequestParameter()

    fun text(text: String) = apply { this.text = text }

    fun textParseMode(parseMode: ParseMode) = apply { this.textParseMode = parseMode }

    fun textEntities(textEntities: Array<MessageEntity>) = apply { this.textEntities = textEntities }

}
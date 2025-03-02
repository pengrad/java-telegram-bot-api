package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.utility.kotlin.checkDeprecatedConstructorParameters
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter

class SendDice private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,
) : KAbstractSendRequest<SendDice>(
    chatId = chatId,
    channelUsername = channelUsername,
) {

    companion object {
        const val DARTS_EMOJI = "🎯"
        const val BASKETBALL_EMOJI = "🏀"
        const val FOOTBALL_EMOJI = "⚽"
        const val BOWLING_EMOJI = "🎳"
        const val SLOT_MACHINE_EMOJI = "🎰"
    }

    constructor(chatId: Long) : this(
        chatId = chatId,
        channelUsername = null
    )

    constructor(channelUsername: String) : this(
        chatId = null,
        channelUsername = channelUsername
    )

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendDice(chatId)"))
    constructor(chatId: Any) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String
    ) {
        checkDeprecatedConstructorParameters()
    }

    var emoji: String? by optionalRequestParameter()

    fun emoji(emoji: String) = applySelf { this.emoji = emoji }

    fun darts() = emoji(DARTS_EMOJI)

    fun basketball() = emoji(BASKETBALL_EMOJI)

    fun football() = emoji(FOOTBALL_EMOJI)

    fun bowling() = emoji(BOWLING_EMOJI)

    fun slotMachine() = emoji(SLOT_MACHINE_EMOJI)

}
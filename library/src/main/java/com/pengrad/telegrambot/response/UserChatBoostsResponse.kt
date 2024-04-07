package com.pengrad.telegrambot.response

import com.pengrad.telegrambot.model.chatboost.ChatBoost

data class UserChatBoostsResponse @JvmOverloads constructor(
        private val result: ChatBoosts = ChatBoosts(emptyList())
) : BaseResponse() {
    data class ChatBoosts(val boosts: List<ChatBoost>)

    fun boosts(): Array<ChatBoost> {
        return result.boosts.toTypedArray()
    }
}
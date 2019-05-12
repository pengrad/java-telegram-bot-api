package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 07 May 2016
 */
class CallbackQuery : Serializable {

    private val id: String? = null
    private val from: User? = null
    private val message: Message? = null
    private val inline_message_id: String? = null
    private val chat_instance: String? = null
    private val data: String? = null
    private val game_short_name: String? = null

    fun id(): String? {
        return id
    }

    fun from(): User? {
        return from
    }

    fun message(): Message? {
        return message
    }

    fun inlineMessageId(): String? {
        return inline_message_id
    }

    fun chatInstance(): String? {
        return chat_instance
    }

    fun data(): String? {
        return data
    }

    fun gameShortName(): String? {
        return game_short_name
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as CallbackQuery?

        if (if (id != null) id != that!!.id else that!!.id != null) return false
        if (if (from != null) from != that.from else that.from != null) return false
        if (if (message != null) message != that.message else that.message != null) return false
        if (if (inline_message_id != null) inline_message_id != that.inline_message_id else that.inline_message_id != null)
            return false
        if (if (chat_instance != null) chat_instance != that.chat_instance else that.chat_instance != null) return false
        if (if (data != null) data != that.data else that.data != null) return false
        return if (game_short_name != null) game_short_name == that.game_short_name else that.game_short_name == null
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "CallbackQuery{" +
                "id='" + id + '\''.toString() +
                ", from=" + from +
                ", message=" + message +
                ", inline_message_id='" + inline_message_id + '\''.toString() +
                ", chat_instance='" + chat_instance + '\''.toString() +
                ", data='" + data + '\''.toString() +
                ", game_short_name='" + game_short_name + '\''.toString() +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

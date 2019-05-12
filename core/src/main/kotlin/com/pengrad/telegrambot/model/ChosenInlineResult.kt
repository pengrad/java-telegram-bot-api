package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 1/20/16.
 */
class ChosenInlineResult : Serializable {

    private val result_id: String? = null
    private val from: User? = null
    private val location: Location? = null
    private val inline_message_id: String? = null
    private val query: String? = null

    fun resultId(): String? {
        return result_id
    }

    fun from(): User? {
        return from
    }

    fun location(): Location? {
        return location
    }

    fun inlineMessageId(): String? {
        return inline_message_id
    }

    fun query(): String? {
        return query
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as ChosenInlineResult?

        if (if (result_id != null) result_id != that!!.result_id else that!!.result_id != null) return false
        if (if (from != null) from != that.from else that.from != null) return false
        if (if (location != null) location != that.location else that.location != null) return false
        if (if (inline_message_id != null) inline_message_id != that.inline_message_id else that.inline_message_id != null)
            return false
        return if (query != null) query == that.query else that.query == null

    }

    override fun hashCode(): Int {
        return result_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "ChosenInlineResult{" +
                "result_id='" + result_id + '\''.toString() +
                ", from=" + from +
                ", location=" + location +
                ", inline_message_id='" + inline_message_id + '\''.toString() +
                ", query='" + query + '\''.toString() +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

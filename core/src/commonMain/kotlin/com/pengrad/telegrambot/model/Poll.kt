package com.pengrad.telegrambot.model

import java.io.Serializable
import java.util.*

/**
 * Stas Parshin
 * 17 April 2019
 */
class Poll : Serializable {

    private val id: String? = null
    private val question: String? = null
    private val options: Array<PollOption>? = null
    private val is_closed: Boolean? = null

    fun id(): String? {
        return id
    }

    fun question(): String? {
        return question
    }

    fun options(): Array<PollOption>? {
        return options
    }

    fun isClosed() = is_closed

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val poll = o as Poll?

        if (if (id != null) id != poll!!.id else poll!!.id != null) return false
        if (if (question != null) question != poll.question else poll.question != null) return false
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(options, poll.options)) return false
        return if (is_closed != null) is_closed == poll.is_closed else poll.is_closed == null
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Poll{" +
                "id='" + id + '\''.toString() +
                ", question='" + question + '\''.toString() +
                ", options=" + Arrays.toString(options) +
                ", is_closed=" + is_closed +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 17 April 2019
 */
class PollOption : Serializable {

    private val text: String? = null
    private val voter_count: Int? = null

    fun text(): String? {
        return text
    }

    fun voterCount(): Int? {
        return voter_count
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as PollOption?

        if (if (text != null) text != that!!.text else that!!.text != null) return false
        return if (voter_count != null) voter_count == that.voter_count else that.voter_count == null
    }

    override fun hashCode(): Int {
        var result = text?.hashCode() ?: 0
        result = 31 * result + (voter_count?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "PollOption{" +
                "text='" + text + '\''.toString() +
                ", voter_count=" + voter_count +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

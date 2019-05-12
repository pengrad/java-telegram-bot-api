package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 03 October 2016
 */
class ResponseParameters : Serializable {

    private val migrate_to_chat_id: Long? = null
    private val retry_after: Int? = null

    fun migrateToChatId(): Long? {
        return migrate_to_chat_id
    }

    fun retryAfter(): Int? {
        return retry_after
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as ResponseParameters?

        if (if (migrate_to_chat_id != null) migrate_to_chat_id != that!!.migrate_to_chat_id else that!!.migrate_to_chat_id != null)
            return false
        return if (retry_after != null) retry_after == that.retry_after else that.retry_after == null
    }

    override fun hashCode(): Int {
        var result = migrate_to_chat_id?.hashCode() ?: 0
        result = 31 * result + (retry_after?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "ResponseParameters{" +
                "migrate_to_chat_id=" + migrate_to_chat_id +
                ", retry_after=" + retry_after +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

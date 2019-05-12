package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 5/3/16.
 */
class MessageEntity : Serializable {

    private val type: Type? = null
    private val offset: Int? = null
    private val length: Int? = null
    private val url: String? = null
    private val user: User? = null

    enum class Type {
        mention, hashtag, cashtag, bot_command, url, email, phone_number, bold, italic, code, pre, text_link,
        text_mention
    }

    fun type(): Type? {
        return type
    }

    fun offset(): Int? {
        return offset
    }

    fun length(): Int? {
        return length
    }

    fun url(): String? {
        return url
    }

    fun user(): User? {
        return user
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as MessageEntity?

        if (type != that!!.type) return false
        if (if (offset != null) offset != that.offset else that.offset != null) return false
        if (if (length != null) length != that.length else that.length != null) return false
        if (if (url != null) url != that.url else that.url != null) return false
        return if (user != null) user == that.user else that.user == null

    }

    override fun hashCode(): Int {
        var result = type?.hashCode() ?: 0
        result = 31 * result + (offset?.hashCode() ?: 0)
        result = 31 * result + (length?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (user?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "MessageEntity{" +
                "type=" + type +
                ", offset=" + offset +
                ", length=" + length +
                ", url='" + url + '\''.toString() +
                ", user=" + user +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

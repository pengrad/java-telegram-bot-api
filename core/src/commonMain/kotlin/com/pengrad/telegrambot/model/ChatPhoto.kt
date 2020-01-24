package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 01 July 2017
 */
class ChatPhoto : Serializable {

    private val small_file_id: String? = null
    private val big_file_id: String? = null

    fun smallFileId(): String? {
        return small_file_id
    }

    fun bigFileId(): String? {
        return big_file_id
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val chatPhoto = o as ChatPhoto?

        if (if (small_file_id != null) small_file_id != chatPhoto!!.small_file_id else chatPhoto!!.small_file_id != null)
            return false
        return if (big_file_id != null) big_file_id == chatPhoto.big_file_id else chatPhoto.big_file_id == null
    }

    override fun hashCode(): Int {
        var result = small_file_id?.hashCode() ?: 0
        result = 31 * result + (big_file_id?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "ChatPhoto{" +
                "small_file_id='" + small_file_id + '\''.toString() +
                ", big_file_id='" + big_file_id + '\''.toString() +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

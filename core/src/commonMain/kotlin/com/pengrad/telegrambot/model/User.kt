package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
data class User(
        private val id: Int? = null,
        private val is_bot: Boolean? = null,
        private val first_name: String? = null,
        private val last_name: String? = null,
        private val username: String? = null,
        private val language_code: String? = null
) : Serializable {

    fun id(): Int? {
        return id
    }

    fun isBot(): Boolean? {
        return is_bot
    }

    fun firstName(): String? {
        return first_name
    }

    fun lastName(): String? {
        return last_name
    }

    fun username(): String? {
        return username
    }

    fun languageCode(): String? {
        return language_code
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
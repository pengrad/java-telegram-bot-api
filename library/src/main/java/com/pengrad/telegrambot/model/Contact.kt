package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
data class Contact(
        @get:JvmName("phoneNumber") val phone_number: String? = null,
        @get:JvmName("firstName") val first_name: String? = null,
        @get:JvmName("lastName") val last_name: String? = null,
        @get:JvmName("userId") val user_id: Int? = null,
        @get:JvmName("vcard") val vcard: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}
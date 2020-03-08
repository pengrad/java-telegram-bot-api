package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
data class Contact(
        @get:JvmName("phoneNumber") @SerialName("phone_number") val phoneNumber: String? = null,
        @get:JvmName("firstName") @SerialName("first_name") val firstName: String? = null,
        @get:JvmName("lastName") @SerialName("last_name") val lastName: String? = null,
        @get:JvmName("userId") @SerialName("user_id") val userId: Int? = null,
        @get:JvmName("vcard") @SerialName("vcard") val vcard: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}
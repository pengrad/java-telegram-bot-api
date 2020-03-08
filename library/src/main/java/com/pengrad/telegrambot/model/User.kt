package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
data class User(
        @get:JvmName("id") val id: Int? = null,
        @get:JvmName("isBot") @SerialName("is_bot") val isBot: Boolean? = null,
        @get:JvmName("firstName") @SerialName("first_name") val firstName: String? = null,
        @get:JvmName("lastName") @SerialName("last_name") val lastName: String? = null,
        @get:JvmName("username") val username: String? = null,
        @get:JvmName("languageCode") @SerialName("language_code") val languageCode: String? = null,
        @get:JvmName("canJoinGroups") @SerialName("can_join_groups") val canJoinGroups: Boolean? = null,
        @get:JvmName("canReadAllGroupMessages") @SerialName("can_read_all_group_messages") val canReadAllGroupMessages: Boolean? = null,
        @get:JvmName("supportsInlineQueries") @SerialName("supports_inline_queries") val supportsInlineQueries: Boolean? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}
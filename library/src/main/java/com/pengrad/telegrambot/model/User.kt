package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
data class User(
        @get:JvmName("id") val id: Int? = null,
        @get:JvmName("isBot") val is_bot: Boolean? = null,
        @get:JvmName("firstName") val first_name: String? = null,
        @get:JvmName("lastName") val last_name: String? = null,
        @get:JvmName("username") val username: String? = null,
        @get:JvmName("languageCode") val language_code: String? = null,
        @get:JvmName("canJoinGroups") val can_join_groups: Boolean? = null,
        @get:JvmName("canReadAllGroupMessages") val can_read_all_group_messages: Boolean? = null,
        @get:JvmName("supportsInlineQueries") val supports_inline_queries: Boolean? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}
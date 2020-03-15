package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
data class Chat(
        @get:JvmName("id") val id: Long? = null,
        @get:JvmName("type") val type: Type? = null,
        //Private
        @get:JvmName("firstName") val first_name: String? = null,
        @get:JvmName("lastName") val last_name: String? = null,
        //Private and Channel
        @get:JvmName("username") val username: String? = null,
        //Channel and Group
        @get:JvmName("title") val title: String? = null,
        @Deprecated("Use permissions field")
        @get:JvmName("allMembersAreAdministrators") val all_members_are_administrators: Boolean? = null,
        @get:JvmName("photo") val photo: ChatPhoto? = null,
        @get:JvmName("description") val description: String? = null,
        @get:JvmName("inviteLink") val invite_link: String? = null,
        @get:JvmName("pinnedMessage") val pinned_message: Message? = null,
        @get:JvmName("permissions") val permissions: ChatPermissions? = null,
        @get:JvmName("slowModeDelay") val slow_mode_delay: Int? = null,
        @get:JvmName("stickerSetName") val sticker_set_name: String? = null,
        @get:JvmName("canSetStickerSet") val can_set_sticker_set: Boolean? = null
) : Serializable {

    enum class Type {
        @SerialName("private")
        Private,
        group,
        supergroup,
        channel
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
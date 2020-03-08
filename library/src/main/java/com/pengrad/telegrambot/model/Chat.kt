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
        @get:JvmName("firstName") @SerialName("first_name") val firstName: String? = null,
        @get:JvmName("lastName") @SerialName("last_name") val lastName: String? = null,
        //Private and Channel
        @get:JvmName("username") val username: String? = null,
        //Channel and Group
        @get:JvmName("title") val title: String? = null,
        @Deprecated("Use permissions field") @get:JvmName("allMembersAreAdministrators") @SerialName("all_members_are_administrators") val allMembersAreAdministrators: Boolean? = null,
        @get:JvmName("photo") val photo: ChatPhoto? = null,
        @get:JvmName("description") val description: String? = null,
        @get:JvmName("inviteLink") @SerialName("invite_link") val inviteLink: String? = null,
        @get:JvmName("pinnedMessage") @SerialName("pinned_message") val pinnedMessage: Message? = null,
        @get:JvmName("permissions") val permissions: ChatPermissions? = null,
        @get:JvmName("slowModeDelay") @SerialName("slow_mode_delay") val slowModeDelay: Int? = null,
        @get:JvmName("stickerSetName") @SerialName("sticker_set_name") val stickerSetName: String? = null,
        @get:JvmName("canSetStickerSet") @SerialName("can_set_sticker_set") val canSetStickerSet: Boolean? = null
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
package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 29 May 2016
 */
data class ChatMember(
        @get:JvmName("user") val user: User? = null,
        @get:JvmName("status") val status: Status? = null,
        @get:JvmName("customTitle") val custom_title: String? = null,
        @get:JvmName("untilDate") val until_date: Int? = null,
        @get:JvmName("canBeEdited") val can_be_edited: Boolean? = null,
        @get:JvmName("canPostMessages") val can_post_messages: Boolean? = null,
        @get:JvmName("canEditMessages") val can_edit_messages: Boolean? = null,
        @get:JvmName("canDeleteMessages") val can_delete_messages: Boolean? = null,
        @get:JvmName("canRestrictMembers") val can_restrict_members: Boolean? = null,
        @get:JvmName("canPromoteMembers") val can_promote_members: Boolean? = null,
        @get:JvmName("canChangeInfo") val can_change_info: Boolean? = null,
        @get:JvmName("canInviteUsers") val can_invite_users: Boolean? = null,
        @get:JvmName("canPinMessages") val can_pin_messages: Boolean? = null,
        @get:JvmName("isMember") val is_member: Boolean? = null,
        @get:JvmName("canSendMessages") val can_send_messages: Boolean? = null,
        @get:JvmName("canSendMediaMessages") val can_send_media_messages: Boolean? = null,
        @get:JvmName("canSendPolls") val can_send_polls: Boolean? = null,
        @get:JvmName("canSendOtherMessages") val can_send_other_messages: Boolean? = null,
        @get:JvmName("canAddWebPagePreviews") val can_add_web_page_previews: Boolean? = null
) : Serializable {

    enum class Status {
        creator, administrator, member, restricted, left, kicked
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
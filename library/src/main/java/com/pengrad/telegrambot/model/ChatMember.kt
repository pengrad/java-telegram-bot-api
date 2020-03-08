package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 29 May 2016
 */
data class ChatMember(
        @get:JvmName("user") val user: User? = null,
        @get:JvmName("status") val status: Status? = null,
        @get:JvmName("customTitle") @SerialName("custom_title") val customTitle: String? = null,
        @get:JvmName("untilDate") @SerialName("until_date") val untilDate: Int? = null,
        @get:JvmName("canBeEdited") @SerialName("can_be_edited") val canBeEdited: Boolean? = null,
        @get:JvmName("canPostMessages") @SerialName("can_post_messages") val canPostMessages: Boolean? = null,
        @get:JvmName("canEditMessages") @SerialName("can_edit_messages") val canEditMessages: Boolean? = null,
        @get:JvmName("canDeleteMessages") @SerialName("can_delete_messages") val canDeleteMessages: Boolean? = null,
        @get:JvmName("canRestrictMembers") @SerialName("can_restrict_members") val canRestrictMembers: Boolean? = null,
        @get:JvmName("canPromoteMembers") @SerialName("can_promote_members") val canPromoteMembers: Boolean? = null,
        @get:JvmName("canChangeInfo") @SerialName("can_change_info") val canChangeInfo: Boolean? = null,
        @get:JvmName("canInviteUsers") @SerialName("can_invite_users") val canInviteUsers: Boolean? = null,
        @get:JvmName("canPinMessages") @SerialName("can_pin_messages") val canPinMessages: Boolean? = null,
        @get:JvmName("isMember") @SerialName("is_member") val isMember: Boolean? = null,
        @get:JvmName("canSendMessages") @SerialName("can_send_messages") val canSendMessages: Boolean? = null,
        @get:JvmName("canSendMediaMessages") @SerialName("can_send_media_messages") val canSendMediaMessages: Boolean? = null,
        @get:JvmName("canSendPolls") @SerialName("can_send_polls") val canSendPolls: Boolean? = null,
        @get:JvmName("canSendOtherMessages") @SerialName("can_send_other_messages") val canSendOtherMessages: Boolean? = null,
        @get:JvmName("canAddWebPagePreviews") @SerialName("can_add_web_page_previews") val canAddWebPagePreviews: Boolean? = null
) : Serializable {

    enum class Status {
        creator, administrator, member, restricted, left, kicked
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
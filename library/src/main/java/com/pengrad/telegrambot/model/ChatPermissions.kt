package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 30 July 2019
 */
data class ChatPermissions(
        @set:JvmSynthetic @get:JvmName("canSendMessages") var can_send_messages: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canSendMediaMessages") var can_send_media_messages: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canSendPolls") var can_send_polls: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canSendOtherMessages") var can_send_other_messages: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canAddWebPagePreviews") var can_add_web_page_previews: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canChangeInfo") var can_change_info: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canInviteUsers") var can_invite_users: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canPinMessages") var can_pin_messages: Boolean? = null
) : Serializable {

    fun canSendMessages(canSendMessages: Boolean) = apply { can_send_messages = canSendMessages }

    fun canSendMediaMessages(canSendMediaMessages: Boolean) = apply { can_send_media_messages = canSendMediaMessages }

    fun canSendPolls(canSendPolls: Boolean) = apply { can_send_polls = canSendPolls }

    fun canSendOtherMessages(canSendOtherMessages: Boolean) = apply { can_send_other_messages = canSendOtherMessages }

    fun canAddWebPagePreviews(canAddWebPagePreviews: Boolean) = apply { can_add_web_page_previews = canAddWebPagePreviews }

    fun canChangeInfo(canChangeInfo: Boolean) = apply { can_change_info = canChangeInfo }

    fun canInviteUsers(canInviteUsers: Boolean) = apply { can_invite_users = canInviteUsers }

    fun canPinMessages(canPinMessages: Boolean) = apply { can_pin_messages = canPinMessages }

    companion object {
        private const val serialVersionUID = 0L
    }
}
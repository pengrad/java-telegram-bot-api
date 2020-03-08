package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 30 July 2019
 */
data class ChatPermissions(
        @set:JvmSynthetic @get:JvmName("canSendMessages") @SerialName("can_send_messages") var canSendMessages: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canSendMediaMessages") @SerialName("can_send_media_messages") var canSendMediaMessages: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canSendPolls") @SerialName("can_send_polls") var canSendPolls: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canSendOtherMessages") @SerialName("can_send_other_messages") var canSendOtherMessages: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canAddWebPagePreviews") @SerialName("can_add_web_page_previews") var canAddWebPagePreviews: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canChangeInfo") @SerialName("can_change_info") var canChangeInfo: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canInviteUsers") @SerialName("can_invite_users") var canInviteUsers: Boolean? = null,
        @set:JvmSynthetic @get:JvmName("canPinMessages") @SerialName("can_pin_messages") var canPinMessages: Boolean? = null
) : Serializable {

    fun canSendMessages(canSendMessages: Boolean) = apply { this.canSendMessages = canSendMessages }

    fun canSendMediaMessages(canSendMediaMessages: Boolean) = apply { this.canSendMediaMessages = canSendMediaMessages }

    fun canSendPolls(canSendPolls: Boolean) = apply { this.canSendPolls = canSendPolls }

    fun canSendOtherMessages(canSendOtherMessages: Boolean) = apply { this.canSendOtherMessages = canSendOtherMessages }

    fun canAddWebPagePreviews(canAddWebPagePreviews: Boolean) = apply { this.canAddWebPagePreviews = canAddWebPagePreviews }

    fun canChangeInfo(canChangeInfo: Boolean) = apply { this.canChangeInfo = canChangeInfo }

    fun canInviteUsers(canInviteUsers: Boolean) = apply { this.canInviteUsers = canInviteUsers }

    fun canPinMessages(canPinMessages: Boolean) = apply { this.canPinMessages = canPinMessages }

    companion object {
        private const val serialVersionUID = 0L
    }
}
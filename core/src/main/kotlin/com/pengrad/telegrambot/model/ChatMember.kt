package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 29 May 2016
 */
class ChatMember : Serializable {

    private val user: User? = null
    private val status: Status? = null

    private val until_date: Int? = null
    private val can_be_edited: Boolean? = null
    private val can_change_info: Boolean? = null
    private val can_post_messages: Boolean? = null
    private val can_edit_messages: Boolean? = null
    private val can_delete_messages: Boolean? = null
    private val can_invite_users: Boolean? = null
    private val can_restrict_members: Boolean? = null
    private val can_pin_messages: Boolean? = null
    private val can_promote_members: Boolean? = null
    private val is_member: Boolean? = null
    private val can_send_messages: Boolean? = null
    private val can_send_media_messages: Boolean? = null
    private val can_send_other_messages: Boolean? = null
    private val can_add_web_page_previews: Boolean? = null

    enum class Status {
        creator, administrator, member, restricted, left, kicked
    }

    fun user(): User? {
        return user
    }

    fun isMember() = is_member;

    fun status(): Status? {
        return status
    }

    fun untilDate(): Int? {
        return until_date
    }

    fun canBeEdited(): Boolean? {
        return can_be_edited
    }

    fun canChangeInfo(): Boolean? {
        return can_change_info
    }

    fun canPostMessages(): Boolean? {
        return can_post_messages
    }

    fun canEditMessages(): Boolean? {
        return can_edit_messages
    }

    fun canDeleteMessages(): Boolean? {
        return can_delete_messages
    }

    fun canInviteUsers(): Boolean? {
        return can_invite_users
    }

    fun canRestrictMembers(): Boolean? {
        return can_restrict_members
    }

    fun canPinMessages(): Boolean? {
        return can_pin_messages
    }

    fun canPromoteMembers(): Boolean? {
        return can_promote_members
    }

    fun canSendMessages(): Boolean? {
        return can_send_messages
    }

    fun canSendMediaMessages(): Boolean? {
        return can_send_media_messages
    }

    fun canSendOtherMessages(): Boolean? {
        return can_send_other_messages
    }

    fun canAddWebPagePreviews(): Boolean? {
        return can_add_web_page_previews
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as ChatMember?

        if (if (user != null) user != that!!.user else that!!.user != null) return false
        if (status != that.status) return false
        if (if (until_date != null) until_date != that.until_date else that.until_date != null) return false
        if (if (can_be_edited != null) can_be_edited != that.can_be_edited else that.can_be_edited != null) return false
        if (if (can_change_info != null) can_change_info != that.can_change_info else that.can_change_info != null)
            return false
        if (if (can_post_messages != null) can_post_messages != that.can_post_messages else that.can_post_messages != null)
            return false
        if (if (can_edit_messages != null) can_edit_messages != that.can_edit_messages else that.can_edit_messages != null)
            return false
        if (if (can_delete_messages != null) can_delete_messages != that.can_delete_messages else that.can_delete_messages != null)
            return false
        if (if (can_invite_users != null) can_invite_users != that.can_invite_users else that.can_invite_users != null)
            return false
        if (if (can_restrict_members != null) can_restrict_members != that.can_restrict_members else that.can_restrict_members != null)
            return false
        if (if (can_pin_messages != null) can_pin_messages != that.can_pin_messages else that.can_pin_messages != null)
            return false
        if (if (can_promote_members != null) can_promote_members != that.can_promote_members else that.can_promote_members != null)
            return false
        if (if (is_member != null) is_member != that.is_member else that.is_member != null) return false
        if (if (can_send_messages != null) can_send_messages != that.can_send_messages else that.can_send_messages != null)
            return false
        if (if (can_send_media_messages != null) can_send_media_messages != that.can_send_media_messages else that.can_send_media_messages != null)
            return false
        if (if (can_send_other_messages != null) can_send_other_messages != that.can_send_other_messages else that.can_send_other_messages != null)
            return false
        return if (can_add_web_page_previews != null) can_add_web_page_previews == that.can_add_web_page_previews else that.can_add_web_page_previews == null
    }

    override fun hashCode(): Int {
        var result = user?.hashCode() ?: 0
        result = 31 * result + (status?.hashCode() ?: 0)
        result = 31 * result + (until_date?.hashCode() ?: 0)
        result = 31 * result + (can_be_edited?.hashCode() ?: 0)
        result = 31 * result + (can_change_info?.hashCode() ?: 0)
        result = 31 * result + (can_post_messages?.hashCode() ?: 0)
        result = 31 * result + (can_edit_messages?.hashCode() ?: 0)
        result = 31 * result + (can_delete_messages?.hashCode() ?: 0)
        result = 31 * result + (can_invite_users?.hashCode() ?: 0)
        result = 31 * result + (can_restrict_members?.hashCode() ?: 0)
        result = 31 * result + (can_pin_messages?.hashCode() ?: 0)
        result = 31 * result + (can_promote_members?.hashCode() ?: 0)
        result = 31 * result + (is_member?.hashCode() ?: 0)
        result = 31 * result + (can_send_messages?.hashCode() ?: 0)
        result = 31 * result + (can_send_media_messages?.hashCode() ?: 0)
        result = 31 * result + (can_send_other_messages?.hashCode() ?: 0)
        result = 31 * result + (can_add_web_page_previews?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "ChatMember{" +
                "user=" + user +
                ", status=" + status +
                ", until_date=" + until_date +
                ", can_be_edited=" + can_be_edited +
                ", can_change_info=" + can_change_info +
                ", can_post_messages=" + can_post_messages +
                ", can_edit_messages=" + can_edit_messages +
                ", can_delete_messages=" + can_delete_messages +
                ", can_invite_users=" + can_invite_users +
                ", can_restrict_members=" + can_restrict_members +
                ", can_pin_messages=" + can_pin_messages +
                ", can_promote_members=" + can_promote_members +
                ", is_member=" + is_member +
                ", can_send_messages=" + can_send_messages +
                ", can_send_media_messages=" + can_send_media_messages +
                ", can_send_other_messages=" + can_send_other_messages +
                ", can_add_web_page_previews=" + can_add_web_page_previews +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

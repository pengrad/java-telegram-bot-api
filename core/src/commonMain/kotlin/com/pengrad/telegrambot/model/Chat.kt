package com.pengrad.telegrambot.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
class Chat : Serializable {

    private val id: Long? = null
    private val type: Type? = null

    //Private
    private val first_name: String? = null
    private val last_name: String? = null

    //Private and Channel
    private val username: String? = null

    //Channel and Group
    private val title: String? = null

    private val all_members_are_administrators: Boolean? = null

    private val photo: ChatPhoto? = null
    private val description: String? = null
    private val invite_link: String? = null
    private val pinned_message: Message? = null
    private val sticker_set_name: String? = null
    private val can_set_sticker_set: Boolean? = null

    enum class Type {
        @SerializedName("private")
        Private,
        group, supergroup, channel
    }

    fun id(): Long? {
        return id
    }

    fun type(): Type? {
        return type
    }

    fun firstName(): String? {
        return first_name
    }

    fun lastName(): String? {
        return last_name
    }

    fun username(): String? {
        return username
    }

    fun title(): String? {
        return title
    }

    fun allMembersAreAdministrators(): Boolean? {
        return all_members_are_administrators
    }

    fun photo(): ChatPhoto? {
        return photo
    }

    fun description(): String? {
        return description
    }

    fun inviteLink(): String? {
        return invite_link
    }

    fun pinnedMessage(): Message? {
        return pinned_message
    }

    fun stickerSetName(): String? {
        return sticker_set_name
    }

    fun canSetStickerSet(): Boolean? {
        return can_set_sticker_set
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val chat = o as Chat?

        if (if (id != null) id != chat!!.id else chat!!.id != null) return false
        if (type != chat.type) return false
        if (if (first_name != null) first_name != chat.first_name else chat.first_name != null) return false
        if (if (last_name != null) last_name != chat.last_name else chat.last_name != null) return false
        if (if (username != null) username != chat.username else chat.username != null) return false
        if (if (title != null) title != chat.title else chat.title != null) return false
        if (if (all_members_are_administrators != null) all_members_are_administrators != chat.all_members_are_administrators else chat.all_members_are_administrators != null)
            return false
        if (if (photo != null) photo != chat.photo else chat.photo != null) return false
        if (if (description != null) description != chat.description else chat.description != null) return false
        if (if (invite_link != null) invite_link != chat.invite_link else chat.invite_link != null) return false
        if (if (pinned_message != null) pinned_message != chat.pinned_message else chat.pinned_message != null) return false
        if (if (sticker_set_name != null) sticker_set_name != chat.sticker_set_name else chat.sticker_set_name != null)
            return false
        return if (can_set_sticker_set != null) can_set_sticker_set == chat.can_set_sticker_set else chat.can_set_sticker_set == null
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Chat{" +
                "id=" + id +
                ", type=" + type +
                ", first_name='" + first_name + '\''.toString() +
                ", last_name='" + last_name + '\''.toString() +
                ", username='" + username + '\''.toString() +
                ", title='" + title + '\''.toString() +
                ", all_members_are_administrators=" + all_members_are_administrators +
                ", photo=" + photo +
                ", description='" + description + '\''.toString() +
                ", invite_link='" + invite_link + '\''.toString() +
                ", pinned_message=" + pinned_message +
                ", sticker_set_name='" + sticker_set_name + '\''.toString() +
                ", can_set_sticker_set=" + can_set_sticker_set +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

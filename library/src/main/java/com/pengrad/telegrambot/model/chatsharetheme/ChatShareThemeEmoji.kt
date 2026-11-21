package com.pengrad.telegrambot.model.chatsharetheme

data class ChatShareThemeEmoji @JvmOverloads constructor(
    @get:JvmName("emojis") val emojis: Array<EmojiType>,
    @get:JvmName("backgroundBackdropId") val backgroundBackdropId: Long? = null,
    override val type: String = ChatShareTheme.EMOJI
) : ChatShareTheme {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChatShareThemeEmoji) return false
        return emojis contentEquals other.emojis &&
                backgroundBackdropId == other.backgroundBackdropId &&
                type == other.type
    }

    override fun hashCode(): Int {
        var result = emojis.contentHashCode()
        result = 31 * result + (backgroundBackdropId?.hashCode() ?: 0)
        result = 31 * result + type.hashCode()
        return result
    }

    override fun toString(): String =
        "ChatShareThemeEmoji(emojis=${emojis.contentToString()}, backgroundBackdropId=$backgroundBackdropId, type=$type)"
}

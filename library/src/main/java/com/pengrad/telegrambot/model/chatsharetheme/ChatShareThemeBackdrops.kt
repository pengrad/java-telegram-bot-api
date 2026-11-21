package com.pengrad.telegrambot.model.chatsharetheme

import java.io.Serializable

data class ChatShareThemeBackdrops(
    @get:JvmName("backdrops") val backdrops: Array<ChatShareThemeBackdrop>,
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChatShareThemeBackdrops) return false
        return backdrops contentEquals other.backdrops
    }

    override fun hashCode(): Int = backdrops.contentHashCode()

    override fun toString(): String = "ChatShareThemeBackdrops(backdrops=${backdrops.contentToString()})"
}

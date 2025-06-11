package com.pengrad.telegrambot.model.story.area.type

import com.pengrad.telegrambot.model.reaction.ReactionType

@Suppress("unused")
class StoryAreaTypeSuggestedReaction private constructor(
    @get:JvmName("reactionType") val reactionType: ReactionType,
    @get:JvmName("isDark") var isDark: Boolean?,
    @get:JvmName("isFlipped") var isFlipped: Boolean?
): StoryAreaType(type = "suggested_reaction") {

    constructor(reactionType: ReactionType) : this(
        reactionType = reactionType,
        isDark = null,
        isFlipped = null
    )

    fun isDark(isDark: Boolean) = apply {
        this.isDark = isDark
    }

    fun isFlipped(isFlipped: Boolean) = apply {
        this.isFlipped = isFlipped
    }

}

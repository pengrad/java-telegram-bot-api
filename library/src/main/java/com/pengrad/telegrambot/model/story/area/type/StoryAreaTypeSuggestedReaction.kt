package com.pengrad.telegrambot.model.story.area.type

import com.pengrad.telegrambot.model.reaction.ReactionType

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

    override fun toString(): String {
        return "StoryAreaTypeSuggestedReaction(reactionType=$reactionType, isDark=$isDark, isFlipped=$isFlipped)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as StoryAreaTypeSuggestedReaction

        if (reactionType != other.reactionType) return false
        if (isDark != other.isDark) return false
        if (isFlipped != other.isFlipped) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + reactionType.hashCode()
        result = 31 * result + (isDark?.hashCode() ?: 0)
        result = 31 * result + (isFlipped?.hashCode() ?: 0)
        return result
    }


}

package com.pengrad.telegrambot.model.gift.unique

data class UniqueGiftColors(
    @get:JvmName("modelCustomEmojiId") val modelCustomEmojiId: String,
    @get:JvmName("symbolCustomEmojiId") val symbolCustomEmojiId: String,
    @get:JvmName("lightThemeMainColor") val lightThemeMainColor: Int,
    @get:JvmName("lightThemeOtherColors") val lightThemeOtherColors: Array<Int>,
    @get:JvmName("darkThemeMainColor") val darkThemeMainColor: Int,
    @get:JvmName("darkThemeOtherColors") val darkThemeOtherColors: Array<Int>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UniqueGiftColors) return false

        return modelCustomEmojiId == other.modelCustomEmojiId &&
                symbolCustomEmojiId == other.symbolCustomEmojiId &&
                lightThemeMainColor == other.lightThemeMainColor &&
                lightThemeOtherColors contentEquals other.lightThemeOtherColors &&
                darkThemeMainColor == other.darkThemeMainColor &&
                darkThemeOtherColors contentEquals other.darkThemeOtherColors
    }

    override fun hashCode(): Int {
        var result = modelCustomEmojiId.hashCode()
        result = 31 * result + symbolCustomEmojiId.hashCode()
        result = 31 * result + lightThemeMainColor
        result = 31 * result + lightThemeOtherColors.contentHashCode()
        result = 31 * result + darkThemeMainColor
        result = 31 * result + darkThemeOtherColors.contentHashCode()
        return result
    }

}

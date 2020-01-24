package com.pengrad.telegrambot.model

import java.io.Serializable
import java.util.Arrays

/**
 * Stas Parshin
 * 23 July 2017
 */
class StickerSet : Serializable {

    private val name: String? = null
    private val title: String? = null
    private val contains_masks: Boolean? = null
    private val stickers: Array<Sticker>? = null

    fun name(): String? {
        return name
    }

    fun title(): String? {
        return title
    }

    fun containsMasks(): Boolean? {
        return contains_masks
    }

    fun stickers(): Array<Sticker>? {
        return stickers
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as StickerSet?

        if (if (name != null) name != that!!.name else that!!.name != null) return false
        if (if (title != null) title != that.title else that.title != null) return false
        return if (if (contains_masks != null) contains_masks != that.contains_masks else that.contains_masks != null) false else Arrays.equals(stickers, that.stickers)
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (contains_masks?.hashCode() ?: 0)
        result = 31 * result + Arrays.hashCode(stickers)
        return result
    }

    override fun toString(): String {
        return "StickerSet{" +
                "name='" + name + '\''.toString() +
                ", title='" + title + '\''.toString() +
                ", contains_masks=" + contains_masks +
                ", stickers=" + Arrays.toString(stickers) +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

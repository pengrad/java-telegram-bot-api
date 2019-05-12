package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
class Sticker : Serializable {

    private val file_id: String? = null
    private val width: Int? = null
    private val height: Int? = null
    private val thumb: PhotoSize? = null
    private val emoji: String? = null
    private val set_name: String? = null
    private val mask_position: MaskPosition? = null
    private val file_size: Int? = null

    fun fileId(): String? {
        return file_id
    }

    fun width(): Int? {
        return width
    }

    fun height(): Int? {
        return height
    }

    fun thumb(): PhotoSize? {
        return thumb
    }

    fun emoji(): String? {
        return emoji
    }

    fun setName(): String? {
        return set_name
    }

    fun maskPosition(): MaskPosition? {
        return mask_position
    }

    fun fileSize(): Int? {
        return file_size
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val sticker = o as Sticker?

        if (if (file_id != null) file_id != sticker!!.file_id else sticker!!.file_id != null) return false
        if (if (width != null) width != sticker.width else sticker.width != null) return false
        if (if (height != null) height != sticker.height else sticker.height != null) return false
        if (if (thumb != null) thumb != sticker.thumb else sticker.thumb != null) return false
        if (if (emoji != null) emoji != sticker.emoji else sticker.emoji != null) return false
        if (if (set_name != null) set_name != sticker.set_name else sticker.set_name != null) return false
        if (if (mask_position != null) mask_position != sticker.mask_position else sticker.mask_position != null) return false
        return if (file_size != null) file_size == sticker.file_size else sticker.file_size == null
    }

    override fun hashCode(): Int {
        return file_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Sticker{" +
                "file_id='" + file_id + '\''.toString() +
                ", width=" + width +
                ", height=" + height +
                ", thumb=" + thumb +
                ", emoji='" + emoji + '\''.toString() +
                ", set_name='" + set_name + '\''.toString() +
                ", mask_position=" + mask_position +
                ", file_size=" + file_size +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

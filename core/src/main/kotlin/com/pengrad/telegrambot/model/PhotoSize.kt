package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
class PhotoSize : Serializable {

    private val file_id: String? = null
    private val width: Int? = null
    private val height: Int? = null
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

    fun fileSize(): Int? {
        return file_size
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val photoSize = o as PhotoSize?

        if (if (file_id != null) file_id != photoSize!!.file_id else photoSize!!.file_id != null) return false
        if (if (width != null) width != photoSize.width else photoSize.width != null) return false
        if (if (height != null) height != photoSize.height else photoSize.height != null) return false
        return if (file_size != null) file_size == photoSize.file_size else photoSize.file_size == null
    }

    override fun hashCode(): Int {
        return file_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "PhotoSize{" +
                "file_id='" + file_id + '\''.toString() +
                ", width=" + width +
                ", height=" + height +
                ", file_size=" + file_size +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

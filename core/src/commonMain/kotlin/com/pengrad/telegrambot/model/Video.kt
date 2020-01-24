package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
class Video : Serializable {

    private val file_id: String? = null
    private val width: Int? = null
    private val height: Int? = null
    private val duration: Int? = null
    private val thumb: PhotoSize? = null
    private val mime_type: String? = null
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

    fun duration(): Int? {
        return duration
    }

    fun thumb(): PhotoSize? {
        return thumb
    }

    fun mimeType(): String? {
        return mime_type
    }

    fun fileSize(): Int? {
        return file_size
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val video = o as Video?

        if (if (file_id != null) file_id != video!!.file_id else video!!.file_id != null) return false
        if (if (width != null) width != video.width else video.width != null) return false
        if (if (height != null) height != video.height else video.height != null) return false
        if (if (duration != null) duration != video.duration else video.duration != null) return false
        if (if (thumb != null) thumb != video.thumb else video.thumb != null) return false
        if (if (mime_type != null) mime_type != video.mime_type else video.mime_type != null) return false
        return if (file_size != null) file_size == video.file_size else video.file_size == null
    }

    override fun hashCode(): Int {
        return file_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Video{" +
                "file_id='" + file_id + '\''.toString() +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", mime_type='" + mime_type + '\''.toString() +
                ", file_size=" + file_size +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

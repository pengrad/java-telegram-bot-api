package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 03 October 2016
 */
class Animation : Serializable {

    private val file_id: String? = null
    private val width: Int? = null
    private val height: Int? = null
    private val duration: Int? = null
    private val thumb: PhotoSize? = null
    private val file_name: String? = null
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

    fun fileName(): String? {
        return file_name
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

        val animation = o as Animation?

        if (if (file_id != null) file_id != animation!!.file_id else animation!!.file_id != null) return false
        if (if (width != null) width != animation.width else animation.width != null) return false
        if (if (height != null) height != animation.height else animation.height != null) return false
        if (if (duration != null) duration != animation.duration else animation.duration != null) return false
        if (if (thumb != null) thumb != animation.thumb else animation.thumb != null) return false
        if (if (file_name != null) file_name != animation.file_name else animation.file_name != null) return false
        if (if (mime_type != null) mime_type != animation.mime_type else animation.mime_type != null) return false
        return if (file_size != null) file_size == animation.file_size else animation.file_size == null
    }

    override fun hashCode(): Int {
        return file_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Animation{" +
                "file_id='" + file_id + '\''.toString() +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", file_name='" + file_name + '\''.toString() +
                ", mime_type='" + mime_type + '\''.toString() +
                ", file_size=" + file_size +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

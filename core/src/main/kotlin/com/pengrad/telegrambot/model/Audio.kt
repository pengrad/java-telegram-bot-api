package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
class Audio : Serializable {

    private val file_id: String? = null
    private val duration: Int? = null
    private val performer: String? = null
    private val title: String? = null
    private val mime_type: String? = null
    private val file_size: Int? = null
    private val thumb: PhotoSize? = null

    fun fileId(): String? {
        return file_id
    }

    fun duration(): Int? {
        return duration
    }

    fun performer(): String? {
        return performer
    }

    fun title(): String? {
        return title
    }

    fun mimeType(): String? {
        return mime_type
    }

    fun fileSize(): Int? {
        return file_size
    }

    fun thumb(): PhotoSize? {
        return thumb
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val audio = o as Audio?

        if (if (file_id != null) file_id != audio!!.file_id else audio!!.file_id != null) return false
        if (if (duration != null) duration != audio.duration else audio.duration != null) return false
        if (if (performer != null) performer != audio.performer else audio.performer != null) return false
        if (if (title != null) title != audio.title else audio.title != null) return false
        if (if (mime_type != null) mime_type != audio.mime_type else audio.mime_type != null) return false
        if (if (file_size != null) file_size != audio.file_size else audio.file_size != null) return false
        return if (thumb != null) thumb == audio.thumb else audio.thumb == null
    }

    override fun hashCode(): Int {
        return file_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Audio{" +
                "file_id='" + file_id + '\''.toString() +
                ", duration=" + duration +
                ", performer='" + performer + '\''.toString() +
                ", title='" + title + '\''.toString() +
                ", mime_type='" + mime_type + '\''.toString() +
                ", file_size=" + file_size +
                ", thumb=" + thumb +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

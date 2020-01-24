package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 23 May 2017
 */
class VideoNote : Serializable {

    private val file_id: String? = null
    private val length: Int? = null
    private val duration: Int? = null
    private val thumb: PhotoSize? = null
    private val file_size: Int? = null

    fun fileId(): String? {
        return file_id
    }

    fun length(): Int? {
        return length
    }

    fun duration(): Int? {
        return duration
    }

    fun thumb(): PhotoSize? {
        return thumb
    }

    fun fileSize(): Int? {
        return file_size
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val videoNote = o as VideoNote?

        if (if (file_id != null) file_id != videoNote!!.file_id else videoNote!!.file_id != null) return false
        if (if (length != null) length != videoNote.length else videoNote.length != null) return false
        if (if (duration != null) duration != videoNote.duration else videoNote.duration != null) return false
        if (if (thumb != null) thumb != videoNote.thumb else videoNote.thumb != null) return false
        return if (file_size != null) file_size == videoNote.file_size else videoNote.file_size == null
    }

    override fun hashCode(): Int {
        return file_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "VideoNote{" +
                "file_id='" + file_id + '\''.toString() +
                ", length=" + length +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", file_size=" + file_size +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

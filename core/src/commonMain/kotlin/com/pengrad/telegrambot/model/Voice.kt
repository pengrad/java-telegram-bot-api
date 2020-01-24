package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 10/21/15.
 */
class Voice : Serializable {

    private val file_id: String? = null
    private val duration: Int? = null
    private val mime_type: String? = null
    private val file_size: Int? = null

    fun fileId(): String? {
        return file_id
    }

    fun duration(): Int? {
        return duration
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

        val voice = o as Voice?

        if (if (file_id != null) file_id != voice!!.file_id else voice!!.file_id != null) return false
        if (if (duration != null) duration != voice.duration else voice.duration != null) return false
        if (if (mime_type != null) mime_type != voice.mime_type else voice.mime_type != null) return false
        return if (file_size != null) file_size == voice.file_size else voice.file_size == null
    }

    override fun hashCode(): Int {
        return file_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Voice{" +
                "file_id='" + file_id + '\''.toString() +
                ", duration=" + duration +
                ", mime_type='" + mime_type + '\''.toString() +
                ", file_size=" + file_size +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
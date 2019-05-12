package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
class Document : Serializable {

    private val file_id: String? = null
    private val thumb: PhotoSize? = null
    private val file_name: String? = null
    private val mime_type: String? = null
    private val file_size: Int? = null

    fun fileId(): String? {
        return file_id
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

        val document = o as Document?

        if (if (file_id != null) file_id != document!!.file_id else document!!.file_id != null) return false
        if (if (thumb != null) thumb != document.thumb else document.thumb != null) return false
        if (if (file_name != null) file_name != document.file_name else document.file_name != null) return false
        if (if (mime_type != null) mime_type != document.mime_type else document.mime_type != null) return false
        return if (file_size != null) file_size == document.file_size else document.file_size == null
    }

    override fun hashCode(): Int {
        return file_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Document{" +
                "file_id='" + file_id + '\''.toString() +
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

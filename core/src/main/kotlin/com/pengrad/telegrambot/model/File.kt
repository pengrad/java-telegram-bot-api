package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 16 October 2015
 */
class File : Serializable {

    private val file_id: String? = null
    private val file_size: Int? = null
    private val file_path: String? = null

    fun fileId(): String? {
        return file_id
    }

    fun fileSize(): Int? {
        return file_size
    }

    fun filePath(): String? {
        return file_path
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val file = o as File?

        if (if (file_id != null) file_id != file!!.file_id else file!!.file_id != null) return false
        if (if (file_size != null) file_size != file.file_size else file.file_size != null) return false
        return if (file_path != null) file_path == file.file_path else file.file_path == null
    }

    override fun hashCode(): Int {
        return file_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "File{" +
                "file_id='" + file_id + '\''.toString() +
                ", file_size=" + file_size +
                ", file_path='" + file_path + '\''.toString() +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

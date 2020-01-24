package com.pengrad.telegrambot.model.request

import com.pengrad.telegrambot.AttachName
import java.io.File
import java.io.Serializable
import java.util.*

/**
 * Stas Parshin
 * 23 November 2017
 */
abstract class InputMedia<T> internal constructor(private val type: String, media: Any) : Serializable {

    private val thisAsT = this as T
    private val media: String
    private var thumb: String? = null
    private var caption: String? = null
    private var parse_mode: String? = null

    @Transient
    private val attachments = HashMap<String, Any>()
    @Transient
    private var filename: String? = null

    val fileName: String
        get() = filename ?: defaultFileName

    protected abstract val defaultFileName: String

    abstract val contentType: String

    init {
        if (media is String) {
            this.media = media
        } else {
            val attachName = AttachName.next()
            this.media = "attach://$attachName"
            attachments[attachName] = media
            if (media is File) {
                filename = media.name
            }
        }
    }

    fun getAttachments(): Map<String, Any> {
        return attachments
    }

    fun thumb(thumb: File): T {
        val attachName = AttachName.next()
        attachments[attachName] = thumb
        this.thumb = "attach://$attachName"
        return thisAsT
    }

    fun thumb(thumb: ByteArray): T {
        val attachName = AttachName.next()
        attachments[attachName] = thumb
        this.thumb = "attach://$attachName"
        return thisAsT
    }

    fun caption(caption: String): T {
        this.caption = caption
        return thisAsT
    }

    fun parseMode(parseMode: ParseMode): T {
        this.parse_mode = parseMode.name
        return thisAsT
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

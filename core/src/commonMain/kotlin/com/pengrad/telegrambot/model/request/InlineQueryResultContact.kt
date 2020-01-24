package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultContact(id: String, private val phone_number: String, private val first_name: String) : InlineQueryResult<InlineQueryResultContact>("contact", id), Serializable {

    private var last_name: String? = null
    private var vcard: String? = null
    private var thumb_url: String? = null
    private var thumb_width: Int? = null
    private var thumb_height: Int? = null

    fun lastName(lastName: String): InlineQueryResultContact {
        this.last_name = lastName
        return this
    }

    fun vcard(vcard: String): InlineQueryResultContact {
        this.vcard = vcard
        return this
    }

    fun thumbUrl(thumbUrl: String): InlineQueryResultContact {
        this.thumb_url = thumbUrl
        return this
    }

    fun thumbWidth(thumbWidth: Int?): InlineQueryResultContact {
        this.thumb_width = thumbWidth
        return this
    }

    fun thumbHeight(thumbHeight: Int?): InlineQueryResultContact {
        this.thumb_height = thumbHeight
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

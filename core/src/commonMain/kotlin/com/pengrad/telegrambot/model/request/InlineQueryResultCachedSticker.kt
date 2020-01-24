package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultCachedSticker(id: String, private val sticker_file_id: String) : InlineQueryResult<InlineQueryResultCachedSticker>("sticker", id), Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}

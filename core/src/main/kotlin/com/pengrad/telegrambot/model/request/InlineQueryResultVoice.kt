package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultVoice(id: String, private val voice_url: String, private val title: String) : InlineQueryResult<InlineQueryResultVoice>("voice", id), Serializable {

    private var caption: String? = null
    private var parse_mode: String? = null
    private var voice_duration: Int? = null

    fun caption(caption: String): InlineQueryResultVoice {
        this.caption = caption
        return this
    }

    fun voiceDuration(voiceDuration: Int?): InlineQueryResultVoice {
        this.voice_duration = voiceDuration
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultVoice {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

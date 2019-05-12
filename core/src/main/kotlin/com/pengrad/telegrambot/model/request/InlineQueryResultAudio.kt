package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultAudio(id: String, private val audio_url: String, private val title: String) : InlineQueryResult<InlineQueryResultAudio>("audio", id), Serializable {

    private var caption: String? = null
    private var parse_mode: String? = null
    private var performer: String? = null
    private var audio_duration: Int? = null

    fun caption(caption: String): InlineQueryResultAudio {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultAudio {
        this.parse_mode = parseMode.name
        return this
    }

    fun performer(performer: String): InlineQueryResultAudio {
        this.performer = performer
        return this
    }

    fun audioDuration(audioDuration: Int?): InlineQueryResultAudio {
        this.audio_duration = audioDuration
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

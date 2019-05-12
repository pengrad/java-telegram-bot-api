package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * stas
 * 1/12/16.
 */
class InlineQueryResultVideo(id: String, private val video_url: String, private val mime_type: String, inputMessageContent: InputMessageContent, private val thumb_url: String, private val title: String) : InlineQueryResult<InlineQueryResultVideo>("video", id), Serializable {

    private var caption: String? = null
    private var parse_mode: String? = null
    private var video_width: Int? = null
    private var video_height: Int? = null
    private var video_duration: Int? = null
    private var description: String? = null

    constructor(id: String, videoUrl: String, mimeType: String, messageText: String, thumbUrl: String, title: String) : this(id, videoUrl, mimeType, InputTextMessageContent(messageText), thumbUrl, title) {}

    init {
        inputMessageContent(inputMessageContent)
    }

    fun caption(caption: String): InlineQueryResultVideo {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultVideo {
        this.parse_mode = parseMode.name
        return this
    }

    fun videoWidth(videoWidth: Int?): InlineQueryResultVideo {
        this.video_width = videoWidth
        return this
    }

    fun videoHeight(videoHeight: Int?): InlineQueryResultVideo {
        this.video_height = videoHeight
        return this
    }

    fun videoDuration(videoDuration: Int?): InlineQueryResultVideo {
        this.video_duration = videoDuration
        return this
    }

    fun description(description: String): InlineQueryResultVideo {
        this.description = description
        return this
    }

    companion object {
        private const val serialVersionUID = 0L

        val MIME_TEXT_HTML = "text/html"
        val MIME_VIDEO_MP4 = "video/mp4"
    }
}

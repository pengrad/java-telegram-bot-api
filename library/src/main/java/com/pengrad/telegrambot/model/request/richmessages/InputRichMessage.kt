package com.pengrad.telegrambot.model.request.richmessages

import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.model.request.richmessages.richblock.InputRichBlock

class InputRichMessage private constructor(
    @get:JvmName("blocks") var blocks: Array<InputRichBlock>?,
    @get:JvmName("html") var html: String?,
    @get:JvmName("markdown") var markdown: String?,
    @get:JvmName("media") var media: Array<InputRichMessageMedia>?,
    @get:JvmName("isRtl") var isRtl: Boolean?,
    @get:JvmName("skipEntityDetection") var skipEntityDetection: Boolean?
) {

    constructor() : this(
        blocks = null,
        html = null,
        markdown = null,
        media = null,
        isRtl = null,
        skipEntityDetection = null
    )

    fun blocks(vararg blocks: InputRichBlock) = apply { this.blocks = arrayOf(*blocks) }

    fun html(html: String) = apply { this.html = html }

    fun markdown(markdown: String) = apply { this.markdown = markdown }

    fun media(vararg media: InputRichMessageMedia) = apply { this.media = arrayOf(*media) }

    fun isRtl(isRtl: Boolean) = apply { this.isRtl = isRtl }

    fun skipEntityDetection(skipEntityDetection: Boolean) = apply { this.skipEntityDetection = skipEntityDetection }

    /**
     * All the media carried by this rich message, for requests that have to upload them.
     */
    fun inputMedia(): List<InputMedia<*>> =
        (media?.map { it.media } ?: emptyList()) + (blocks?.flatMap { it.inputMedia() } ?: emptyList())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichMessage
        return blocks.contentEquals(other.blocks) &&
                html == other.html &&
                markdown == other.markdown &&
                media.contentEquals(other.media) &&
                isRtl == other.isRtl &&
                skipEntityDetection == other.skipEntityDetection
    }

    override fun hashCode(): Int {
        var result = blocks?.contentHashCode() ?: 0
        result = 31 * result + (html?.hashCode() ?: 0)
        result = 31 * result + (markdown?.hashCode() ?: 0)
        result = 31 * result + (media?.contentHashCode() ?: 0)
        result = 31 * result + (isRtl?.hashCode() ?: 0)
        result = 31 * result + (skipEntityDetection?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichMessage(blocks=${blocks?.contentToString()}, html=$html, markdown=$markdown, media=${media?.contentToString()}, isRtl=$isRtl, skipEntityDetection=$skipEntityDetection)"
}

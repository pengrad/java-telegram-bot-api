package com.pengrad.telegrambot.model.request.richmessages

class InputRichMessage private constructor(
    @get:JvmName("html") var html: String?,
    @get:JvmName("markdown") var markdown: String?,
    @get:JvmName("media") var media: Array<InputRichMessageMedia>?,
    @get:JvmName("isRtl") var isRtl: Boolean?,
    @get:JvmName("skipEntityDetection") var skipEntityDetection: Boolean?
) {

    constructor() : this(
        html = null,
        markdown = null,
        media = null,
        isRtl = null,
        skipEntityDetection = null
    )

    fun html(html: String) = apply { this.html = html }

    fun markdown(markdown: String) = apply { this.markdown = markdown }

    fun media(vararg media: InputRichMessageMedia) = apply { this.media = arrayOf(*media) }

    fun isRtl(isRtl: Boolean) = apply { this.isRtl = isRtl }

    fun skipEntityDetection(skipEntityDetection: Boolean) = apply { this.skipEntityDetection = skipEntityDetection }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichMessage
        return html == other.html &&
                markdown == other.markdown &&
                media.contentEquals(other.media) &&
                isRtl == other.isRtl &&
                skipEntityDetection == other.skipEntityDetection
    }

    override fun hashCode(): Int {
        var result = html?.hashCode() ?: 0
        result = 31 * result + (markdown?.hashCode() ?: 0)
        result = 31 * result + (media?.contentHashCode() ?: 0)
        result = 31 * result + (isRtl?.hashCode() ?: 0)
        result = 31 * result + (skipEntityDetection?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichMessage(html=$html, markdown=$markdown, media=${media?.contentToString()}, isRtl=$isRtl, skipEntityDetection=$skipEntityDetection)"
}

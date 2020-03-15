package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
data class Update(
        @get:JvmName("updateId") val update_id: Int? = null,
        @get:JvmName("message") val message: Message? = null,
        @get:JvmName("editedMessage") val edited_message: Message? = null,
        @get:JvmName("channelPost") val channel_post: Message? = null,
        @get:JvmName("editedChannelPost") val edited_channel_post: Message? = null,
        @get:JvmName("inlineQuery") val inline_query: InlineQuery? = null,
        @get:JvmName("chosenInlineResult") val chosen_inline_result: ChosenInlineResult? = null,
        @get:JvmName("callbackQuery") val callback_query: CallbackQuery? = null,
        @get:JvmName("shippingQuery") val shipping_query: ShippingQuery? = null,
        @get:JvmName("preCheckoutQuery") val pre_checkout_query: PreCheckoutQuery? = null,
        @get:JvmName("poll") val poll: Poll? = null,
        @get:JvmName("pollAnswer") val poll_answer: PollAnswer? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}
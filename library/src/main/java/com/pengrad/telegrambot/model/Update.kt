package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
data class Update(
        @get:JvmName("updateId") @SerialName("update_id") val updateId: Int? = null,
        @get:JvmName("message") val message: Message? = null,
        @get:JvmName("editedMessage") @SerialName("edited_message") val editedMessage: Message? = null,
        @get:JvmName("channelPost") @SerialName("channel_post") val channelPost: Message? = null,
        @get:JvmName("editedChannelPost") @SerialName("edited_channel_post") val editedChannelPost: Message? = null,
        @get:JvmName("inlineQuery") @SerialName("inline_query") val inlineQuery: InlineQuery? = null,
        @get:JvmName("chosenInlineResult") @SerialName("chosen_inline_result") val chosenInlineResult: ChosenInlineResult? = null,
        @get:JvmName("callbackQuery") @SerialName("callback_query") val callbackQuery: CallbackQuery? = null,
        @get:JvmName("shippingQuery") @SerialName("shipping_query") val shippingQuery: ShippingQuery? = null,
        @get:JvmName("preCheckoutQuery") @SerialName("pre_checkout_query") val preCheckoutQuery: PreCheckoutQuery? = null,
        @get:JvmName("poll") val poll: Poll? = null,
        @get:JvmName("pollAnswer") @SerialName("poll_answer") val pollAnswer: PollAnswer? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}
package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
class Update : Serializable {

    private val update_id: Int? = null
    private val message: Message? = null
    private val edited_message: Message? = null
    private val channel_post: Message? = null
    private val edited_channel_post: Message? = null
    private val inline_query: InlineQuery? = null
    private val chosen_inline_result: ChosenInlineResult? = null
    private val callback_query: CallbackQuery? = null
    private val shipping_query: ShippingQuery? = null
    private val pre_checkout_query: PreCheckoutQuery? = null
    private val poll: Poll? = null

    fun updateId(): Int? {
        return update_id
    }

    fun message(): Message? {
        return message
    }

    fun editedMessage(): Message? {
        return edited_message
    }

    fun channelPost(): Message? {
        return channel_post
    }

    fun editedChannelPost(): Message? {
        return edited_channel_post
    }

    fun inlineQuery(): InlineQuery? {
        return inline_query
    }

    fun chosenInlineResult(): ChosenInlineResult? {
        return chosen_inline_result
    }

    fun callbackQuery(): CallbackQuery? {
        return callback_query
    }

    fun shippingQuery(): ShippingQuery? {
        return shipping_query
    }

    fun preCheckoutQuery(): PreCheckoutQuery? {
        return pre_checkout_query
    }

    fun poll(): Poll? {
        return poll
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val update = o as Update?

        if (if (update_id != null) update_id != update!!.update_id else update!!.update_id != null) return false
        if (if (message != null) message != update.message else update.message != null) return false
        if (if (edited_message != null) edited_message != update.edited_message else update.edited_message != null)
            return false
        if (if (channel_post != null) channel_post != update.channel_post else update.channel_post != null) return false
        if (if (edited_channel_post != null) edited_channel_post != update.edited_channel_post else update.edited_channel_post != null)
            return false
        if (if (inline_query != null) inline_query != update.inline_query else update.inline_query != null) return false
        if (if (chosen_inline_result != null) chosen_inline_result != update.chosen_inline_result else update.chosen_inline_result != null)
            return false
        if (if (callback_query != null) callback_query != update.callback_query else update.callback_query != null)
            return false
        if (if (shipping_query != null) shipping_query != update.shipping_query else update.shipping_query != null)
            return false
        if (if (pre_checkout_query != null) pre_checkout_query != update.pre_checkout_query else update.pre_checkout_query != null)
            return false
        return if (poll != null) poll == update.poll else update.poll == null
    }

    override fun hashCode(): Int {
        return update_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Update{" +
                "update_id=" + update_id +
                ", message=" + message +
                ", edited_message=" + edited_message +
                ", channel_post=" + channel_post +
                ", edited_channel_post=" + edited_channel_post +
                ", inline_query=" + inline_query +
                ", chosen_inline_result=" + chosen_inline_result +
                ", callback_query=" + callback_query +
                ", shipping_query=" + shipping_query +
                ", pre_checkout_query=" + pre_checkout_query +
                ", poll=" + poll +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}

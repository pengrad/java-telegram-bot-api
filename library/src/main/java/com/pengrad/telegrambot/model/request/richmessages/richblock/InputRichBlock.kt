package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.request.InputMedia

interface InputRichBlock {
    val type: String

    /**
     * The media carried by this block, for requests that have to upload them.
     */
    fun inputMedia(): List<InputMedia<*>> = emptyList()
}

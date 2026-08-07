package com.pengrad.telegrambot.model.request.richmessages

import com.pengrad.telegrambot.model.request.InputMedia

data class InputRichMessageMedia(
    @get:JvmName("id") val id: String,
    @get:JvmName("media") val media: InputMedia<*>
)

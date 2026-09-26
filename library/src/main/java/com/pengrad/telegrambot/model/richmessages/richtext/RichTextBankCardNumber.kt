package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextBankCardNumber @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("bankCardNumber") val bankCardNumber: String,
    override val type: String = RichTextType.BANK_CARD_NUMBER
) : RichText

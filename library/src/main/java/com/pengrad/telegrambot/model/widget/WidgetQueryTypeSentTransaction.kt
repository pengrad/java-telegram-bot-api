package com.pengrad.telegrambot.model.widget

data class WidgetQueryTypeSentTransaction @JvmOverloads constructor(
    @get:JvmName("wallet") val wallet: WidgetQueryWallet,
    @get:JvmName("msgHash") val msgHash: String,
    override val type: String = WidgetQueryType.SENT_TRANSACTION
) : WidgetQueryType

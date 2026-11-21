package com.pengrad.telegrambot.model.widget

data class WidgetQueryTypeSignData @JvmOverloads constructor(
    @get:JvmName("wallet") val wallet: WidgetQueryWallet,
    @get:JvmName("signData") val signData: String,
    override val type: String = WidgetQueryType.SIGN_DATA
) : WidgetQueryType

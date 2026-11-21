package com.pengrad.telegrambot.model.widget

import com.pengrad.telegrambot.model.ton.TonWalletCard

data class WidgetQueryTypeData @JvmOverloads constructor(
    @get:JvmName("walletCard") val walletCard: TonWalletCard? = null,
    override val type: String = WidgetQueryType.DATA
) : WidgetQueryType

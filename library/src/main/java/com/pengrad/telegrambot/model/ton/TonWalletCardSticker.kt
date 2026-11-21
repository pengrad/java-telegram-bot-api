package com.pengrad.telegrambot.model.ton

import com.pengrad.telegrambot.model.AreaPosition
import java.io.Serializable

data class TonWalletCardSticker(
    @get:JvmName("position") val position: AreaPosition,
    @get:JvmName("nft") val nft: TonNft,
) : Serializable

package com.pengrad.telegrambot.model.gift.unique

@Suppress("unused")
data class UniqueGiftInfo(
    @get:JvmName("gift")  val gift: UniqueGift,
    @get:JvmName("origin")  val origin: String,
    @get:JvmName("ownedGiftId")  val ownedGiftId: String?,
    @get:JvmName("transferStarCount")  val transferStarCount: Int?,
    @get:JvmName("nextTransferDate") var nextTransferDate: Long?,
    @Deprecated("Use lastResaleCurrency and lastResaleAmount instead")
    @get:JvmName("lastResaleStarCount")  val lastResaleStarCount: Int?,
    @get:JvmName("lastResaleCurrency")  val lastResaleCurrency: String?,
    @get:JvmName("lastResaleAmount")  val lastResaleAmount: Long?
)
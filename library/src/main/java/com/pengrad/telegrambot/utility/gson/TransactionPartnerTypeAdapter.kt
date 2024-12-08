package com.pengrad.telegrambot.utility.gson

import com.google.gson.*
import com.pengrad.telegrambot.model.stars.partner.*
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.AFFILIATE_PROGRAM
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.FRAGMENT
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.OTHER
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.TELEGRAM_ADS
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.TELEGRAM_API
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.UNKNOWN
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.USER
import java.lang.reflect.Type

object TransactionPartnerTypeAdapter : JsonDeserializer<TransactionPartner> {

    private val typeMapping = mapOf(
        USER to TransactionPartnerUser::class,
        AFFILIATE_PROGRAM to TransactionPartnerAffiliateProgram::class,
        FRAGMENT to TransactionPartnerFragment::class,
        TELEGRAM_ADS to TransactionPartnerTelegramAds::class,
        TELEGRAM_API to TransactionPartnerTelegramApi::class,
        OTHER to TransactionPartnerOther::class
    )

    @Throws(JsonParseException::class)
    override fun deserialize(
        element: JsonElement,
        type: Type,
        context: JsonDeserializationContext
    ): TransactionPartner {
        val obj = element.asJsonObject
        val discriminator = obj.getAsJsonPrimitive("type")?.asString ?: UNKNOWN

        return typeMapping[discriminator]?.let {
            context.deserialize(obj, it.java)
        } ?: TransactionPartnerUnknown(discriminator)
    }

}
package com.pengrad.telegrambot.utility.gson

import com.google.gson.*
import com.pengrad.telegrambot.model.stars.partner.*
import java.lang.reflect.Type

object TransactionPartnerTypeAdapter : JsonDeserializer<TransactionPartner> {

    private val typeMapping = mapOf(
        TransactionPartnerUser.TYPE to TransactionPartnerUser::class,
        TransactionPartnerFragment.TYPE to TransactionPartnerFragment::class,
        TransactionPartnerTelegramAds.TYPE to TransactionPartnerTelegramAds::class,
        TransactionPartnerTelegramApi.TYPE to TransactionPartnerTelegramApi::class,
        TransactionPartnerOther.TYPE to TransactionPartnerOther::class
    )

    @Throws(JsonParseException::class)
    override fun deserialize(
        element: JsonElement,
        type: Type,
        context: JsonDeserializationContext
    ): TransactionPartner {
        val obj = element.asJsonObject
        val discriminator = obj.getAsJsonPrimitive("type")?.asString ?: "unknown"

        return typeMapping[discriminator]?.let {
            context.deserialize(obj, it.java)
        } ?: TransactionPartner(discriminator)
    }

}
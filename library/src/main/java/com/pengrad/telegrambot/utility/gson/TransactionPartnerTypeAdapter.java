package com.pengrad.telegrambot.utility.gson;

import com.google.gson.*;
import com.pengrad.telegrambot.model.stars.partner.*;
import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalState;
import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalStateFailed;
import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalStatePending;
import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalStateSucceeded;

import java.lang.reflect.Type;

public class TransactionPartnerTypeAdapter implements JsonDeserializer<TransactionPartner> {

    @Override
    public TransactionPartner deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = element.getAsJsonObject();
        String discriminator = object.getAsJsonPrimitive("type").getAsString();

        if (TransactionPartnerUser.TYPE.equals(discriminator)) {
            return context.deserialize(object, TransactionPartnerUser.class);
        } else if (TransactionPartnerFragment.TYPE.equals(discriminator)) {
            return context.deserialize(object, TransactionPartnerFragment.class);
        } else if (TransactionPartnerTelegramAds.TYPE.equals(discriminator)) {
            return context.deserialize(object, TransactionPartnerTelegramAds.class);
        } else if (TransactionPartnerOther.TYPE.equals(discriminator)) {
            return context.deserialize(object, TransactionPartnerOther.class);
        }

        return context.deserialize(object, TransactionPartner.class);
    }
}

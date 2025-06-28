package com.pengrad.telegrambot.utility.gson;

import com.google.gson.*;
import com.pengrad.telegrambot.model.gift.owned.OwnedGift;
import com.pengrad.telegrambot.model.gift.owned.OwnedGiftRegular;
import com.pengrad.telegrambot.model.gift.owned.OwnedGiftUnique;
import com.pengrad.telegrambot.model.paidmedia.PaidMedia;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaPhoto;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaPreview;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaVideo;

import java.lang.reflect.Type;

public class OwnedGiftTypeAdapter implements JsonDeserializer<OwnedGift> {

    @Override
    public OwnedGift deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = element.getAsJsonObject();
        JsonPrimitive primitive = object.getAsJsonPrimitive("type");
        String discriminator = primitive != null ? primitive.getAsString() : "unknown";

        if (OwnedGiftRegular.TYPE.equals(discriminator)) {
            return context.deserialize(object, OwnedGiftRegular.class);
        } else if (OwnedGiftUnique.TYPE.equals(discriminator)) {
            return context.deserialize(object, OwnedGiftUnique.class);
        }

        return new OwnedGift(discriminator);
    }
}

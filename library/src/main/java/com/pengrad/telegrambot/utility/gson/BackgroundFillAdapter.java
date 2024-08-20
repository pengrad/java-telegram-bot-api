package com.pengrad.telegrambot.utility.gson;

import com.google.gson.*;
import com.pengrad.telegrambot.model.chatbackground.BackgroundFill;
import com.pengrad.telegrambot.model.chatbackground.BackgroundFillFreeformGradient;
import com.pengrad.telegrambot.model.chatbackground.BackgroundFillGradient;
import com.pengrad.telegrambot.model.chatbackground.BackgroundFillSolid;

import java.lang.reflect.Type;

public class BackgroundFillAdapter implements JsonDeserializer<BackgroundFill> {

    @Override
    public BackgroundFill deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = element.getAsJsonObject();
        JsonPrimitive primitive = object.getAsJsonPrimitive("type");
        String discriminator = primitive != null ? primitive.getAsString() : "unknown";

        if (BackgroundFillSolid.TYPE.equals(discriminator)) {
            return context.deserialize(object, BackgroundFillSolid.class);
        } else if (BackgroundFillGradient.TYPE.equals(discriminator)) {
            return context.deserialize(object, BackgroundFillGradient.class);
        } else if (BackgroundFillFreeformGradient.TYPE.equals(discriminator)) {
            return context.deserialize(object, BackgroundFillFreeformGradient.class);
        }

        return new BackgroundFill(discriminator);
    }
}

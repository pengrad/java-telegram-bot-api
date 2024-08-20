package com.pengrad.telegrambot.utility.gson;

import com.google.gson.*;
import com.pengrad.telegrambot.model.chatbackground.BackgroundType;
import com.pengrad.telegrambot.model.chatbackground.BackgroundTypeChatTheme;
import com.pengrad.telegrambot.model.chatbackground.BackgroundTypeFill;
import com.pengrad.telegrambot.model.chatbackground.BackgroundTypePattern;
import com.pengrad.telegrambot.model.chatbackground.BackgroundTypeWallpaper;

import java.lang.reflect.Type;

public class BackgroundTypeAdapter implements JsonDeserializer<BackgroundType> {

    @Override
    public BackgroundType deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = element.getAsJsonObject();
        JsonPrimitive primitive = object.getAsJsonPrimitive("type");
        String discriminator = primitive != null ? primitive.getAsString() : "unknown";

        if (BackgroundTypeFill.TYPE.equals(discriminator)) {
            return context.deserialize(object, BackgroundTypeFill.class);
        } else if (BackgroundTypeWallpaper.TYPE.equals(discriminator)) {
            return context.deserialize(object, BackgroundTypeWallpaper.class);
        } else if (BackgroundTypePattern.TYPE.equals(discriminator)) {
            return context.deserialize(object, BackgroundTypePattern.class);
        } else if (BackgroundTypeChatTheme.TYPE.equals(discriminator)) {
            return context.deserialize(object, BackgroundTypeChatTheme.class);
        }

        return new BackgroundType(discriminator);
    }
}

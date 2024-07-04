package com.pengrad.telegrambot.utility.gson;

import com.google.gson.*;
import com.pengrad.telegrambot.model.paidmedia.PaidMedia;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaPhoto;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaPreview;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaVideo;

import java.lang.reflect.Type;

public class PaidMediaTypeAdapter implements JsonDeserializer<PaidMedia> {

    @Override
    public PaidMedia deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = element.getAsJsonObject();
        String discriminator = object.getAsJsonPrimitive("type").getAsString();

        if (PaidMediaPreview.TYPE.equals(discriminator)) {
            return context.deserialize(object, PaidMediaPreview.class);
        } else if (PaidMediaPhoto.TYPE.equals(discriminator)) {
            return context.deserialize(object, PaidMediaPhoto.class);
        } else if (PaidMediaVideo.TYPE.equals(discriminator)) {
            return context.deserialize(object, PaidMediaVideo.class);
        }

        return context.deserialize(object, PaidMedia.class);
    }
}

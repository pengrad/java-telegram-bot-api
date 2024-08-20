package com.pengrad.telegrambot.utility.gson;

import com.google.gson.*;
import com.pengrad.telegrambot.model.reaction.ReactionType;
import com.pengrad.telegrambot.model.reaction.ReactionTypeCustomEmoji;
import com.pengrad.telegrambot.model.reaction.ReactionTypeEmoji;
import com.pengrad.telegrambot.model.reaction.ReactionTypePaid;

import java.lang.reflect.Type;

public class ReactionTypeAdapter implements JsonDeserializer<ReactionType> {

    @Override
    public ReactionType deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = element.getAsJsonObject();
        JsonPrimitive primitive = object.getAsJsonPrimitive("type");
        String discriminator = primitive != null ? primitive.getAsString() : "unknown";

        if (ReactionTypeEmoji.EMOJI_TYPE.equals(discriminator)) {
            return context.deserialize(object, ReactionTypeEmoji.class);
        } else if (ReactionTypeCustomEmoji.CUSTOM_EMOJI_TYPE.equals(discriminator)) {
            return context.deserialize(object, ReactionTypeCustomEmoji.class);
        } else if (ReactionTypePaid.PAID_TYPE.equals(discriminator)) {
            return context.deserialize(object, ReactionTypePaid.class);
        }

        return new ReactionType(discriminator);
    }
}

package com.pengrad.telegrambot.utility.gson;

import com.google.gson.*;
import com.pengrad.telegrambot.model.reaction.ReactionType;
import com.pengrad.telegrambot.model.reaction.ReactionTypeCustomEmoji;
import com.pengrad.telegrambot.model.reaction.ReactionTypeEmoji;

import java.lang.reflect.Type;

public class ReactionTypeAdapter implements JsonDeserializer<ReactionType> {

    @Override
    public ReactionType deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = element.getAsJsonObject();
        String discriminator = object.getAsJsonPrimitive("type").getAsString();

        if (ReactionTypeEmoji.EMOJI_TYPE.equals(discriminator)) {
            return context.deserialize(object, ReactionTypeEmoji.class);
        } else if (ReactionTypeCustomEmoji.CUSTOM_EMOJI_TYPE.equals(discriminator)) {
            return context.deserialize(object, ReactionTypeCustomEmoji.class);
        }

        return context.deserialize(object, ReactionType.class);
    }
}

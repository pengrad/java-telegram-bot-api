package com.pengrad.telegrambot.utility.gson;

import com.google.gson.*;
import com.pengrad.telegrambot.model.message.origin.*;

import java.lang.reflect.Type;

public class MessageOriginTypeAdapter implements JsonDeserializer<MessageOrigin> {

    @Override
    public MessageOrigin deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = element.getAsJsonObject();
        JsonPrimitive primitive = object.getAsJsonPrimitive("type");
        String discriminator = primitive != null ? primitive.getAsString() : "unknown";

        if (MessageOriginChannel.MESSAGE_ORIGIN_TYPE.equals(discriminator)) {
            return context.deserialize(object, MessageOriginChannel.class);
        } else if (MessageOriginChat.MESSAGE_ORIGIN_TYPE.equals(discriminator)) {
            return context.deserialize(object, MessageOriginChat.class);
        } else if (MessageOriginHiddenUser.MESSAGE_ORIGIN_TYPE.equals(discriminator)) {
            return context.deserialize(object, MessageOriginHiddenUser.class);
        } else if (MessageOriginUser.MESSAGE_ORIGIN_TYPE.equals(discriminator)) {
            return context.deserialize(object, MessageOriginUser.class);
        }

        return new MessageOrigin(discriminator);
    }
}

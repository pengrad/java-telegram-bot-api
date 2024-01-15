package com.pengrad.telegrambot.utility.gson;

import com.google.gson.*;
import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSourceGiftCode;
import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSourceGiveaway;
import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSourcePremium;
import com.pengrad.telegrambot.model.messageorigin.*;

import java.lang.reflect.Type;

public class ChatBoostTypeAdapter implements JsonDeserializer<MessageOrigin> {

    @Override
    public MessageOrigin deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = element.getAsJsonObject();
        String discriminator = object.getAsJsonPrimitive("source").getAsString();

        if (ChatBoostSourceGiftCode.CHAT_BOOST_TYPE.equals(discriminator)) {
            return context.deserialize(object, ChatBoostSourceGiftCode.class);
        } else if (ChatBoostSourceGiveaway.CHAT_BOOST_TYPE.equals(discriminator)) {
            return context.deserialize(object, ChatBoostSourceGiveaway.class);
        } else if (ChatBoostSourcePremium.CHAT_BOOST_TYPE.equals(discriminator)) {
            return context.deserialize(object, ChatBoostSourcePremium.class);
        }

        throw new JsonParseException("Unknown ChatBoost type: " + discriminator);
    }
}

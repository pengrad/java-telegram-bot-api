package com.pengrad.telegrambot;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import retrofit.converter.GsonConverter;
import retrofit.mime.FormUrlEncodedTypedOutput;
import retrofit.mime.TypedOutput;

import java.util.Map;
import java.util.Set;

/**
 * stas
 * 8/4/15.
 */
public class GsonUrlEncodedConverter extends GsonConverter {
    private final Gson gson;

    public GsonUrlEncodedConverter(Gson gson) {
        this(gson, "UTF-8");
    }

    public GsonUrlEncodedConverter(Gson gson, String charset) {
        super(gson, charset);
        this.gson = gson;
    }

    @Override
    public TypedOutput toBody(Object object) {
        try {
            Set<Map.Entry<String, JsonElement>> fieldSet = gson.toJsonTree(object).getAsJsonObject().entrySet();
            FormUrlEncodedTypedOutput formUrlEncodedTypedOutput = new FormUrlEncodedTypedOutput();
            for (Map.Entry<String, JsonElement> entry : fieldSet) {
                String valueString;
                if (!entry.getValue().isJsonPrimitive()) {
                    valueString = entry.getValue().toString();
                } else {
                    valueString = entry.getValue().getAsJsonPrimitive().getAsString();
                }
                formUrlEncodedTypedOutput.addField(entry.getKey(), valueString);
            }
            return formUrlEncodedTypedOutput;
        } catch (IllegalStateException e) {
            return super.toBody(object);
        }
    }
}
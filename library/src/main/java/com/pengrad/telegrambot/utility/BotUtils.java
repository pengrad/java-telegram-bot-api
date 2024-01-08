package com.pengrad.telegrambot.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.reaction.ReactionType;
import com.pengrad.telegrambot.utility.gson.ReactionTypeAdapter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * stas
 * 11/1/15.
 */
public class BotUtils {

    private BotUtils() {}

    public static final Gson GSON = new GsonBuilder()
        .registerTypeAdapter(ReactionType.class, new ReactionTypeAdapter())
        .create();

    public static Update parseUpdate(String update) {
        return GSON.fromJson(update, Update.class);
    }

    public static Update parseUpdate(Reader reader) {
        return GSON.fromJson(reader, Update.class);
    }

    static byte[] getBytesFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[0xFFFF];
        for (int len = is.read(buffer); len != -1; len = is.read(buffer)) {
            os.write(buffer, 0, len);
        }
        return os.toByteArray();
    }

    public static <R> R fromJson(String jsonString, Class<R> resClass) {
        return GSON.fromJson(jsonString,resClass);
    }

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }
}

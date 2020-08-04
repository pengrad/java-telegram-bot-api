package com.pengrad.telegrambot;

import com.google.gson.Gson;
import com.pengrad.telegrambot.model.Update;

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

    private static final Gson gson = new Gson();

    public static Update parseUpdate(String update) {
        return gson.fromJson(update, Update.class);
    }

    public static Update parseUpdate(Reader reader) {
        return gson.fromJson(reader, Update.class);
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
        return gson.fromJson(jsonString,resClass);
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }
}

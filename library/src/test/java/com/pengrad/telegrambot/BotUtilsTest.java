package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.*;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Stas Parshin
 * 26 January 2020
 */
public class BotUtilsTest {

    final String updateStr = "{\"update_id\":874199391,\n" +
            "\"message\":{\"message_id\":33111,\"from\":{\"id\":1231231231,\"is_bot\":false,\"first_name\":\"RRRR\",\"username\":\"RRRR54321\"},\"chat\":{\"id\":-23123123123123,\"title\":\"hhh iiiiii ccccc\",\"type\":\"supergroup\"},\"date\":1579958705,\"text\":\"block the news\"}}";

    private void check(Update update) {
        assertEquals(update.updateId(), Integer.valueOf(874199391));
        assertEquals(update.message().messageId(), Integer.valueOf(33111));
    }

    @Test
    public void parseUpdateString() {
        Update update = BotUtils.parseUpdate(updateStr);
        check(update);
    }

    @Test
    public void parseUpdateReader() {
        Update update = BotUtils.parseUpdate(new StringReader(updateStr));
        check(update);
    }

    @Test
    public void getBytesFromInputStream() throws IOException {
        byte[] src = {1, 2, 3, 4};
        byte[] bytes = BotUtils.getBytesFromInputStream(new ByteArrayInputStream(src));
        assertArrayEquals(bytes, src);
    }
}
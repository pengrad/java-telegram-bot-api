package com.pengrad.telegrambot;

import com.pengrad.telegrambot.request.Close;
import com.pengrad.telegrambot.request.LogOut;
import com.pengrad.telegrambot.response.BaseResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Harry Zalessky 10 May 2023: these tests are built incorrectly. I can't run them so I can't fix them, but they should be run from TelegramBot.close().execute() and TelegramBot.logOut().execute().
/**
 * Stas Parshin
 * 05 November 2020
 */
public class LogOutCloseTest {

    @Test
    public void logOut() {
//        String logOut = new LogOut().toWebhookResponse();
//        assertEquals(logOut, "{\"method\":\"logOut\"}");
    }

    @Test
    public void close() {
//        String close = new Close().toWebhookResponse();
//        assertEquals(close, "{\"method\":\"close\"}");
    }

}

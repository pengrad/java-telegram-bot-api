package com.pengrad.telegrambot.login;

import org.junit.Test;

import java.util.Date;

import static com.pengrad.telegrambot.UpdatesListenerTest.token;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Stas Parshin
 * 18 June 2019
 */
public class CheckTelegramAuthTest {

    @Test
    public void login() throws Exception {
        String data = "google.com/?id=51314083&first_name=Stas&last_name=Parshin&username=pengrad&photo_url=https://t.me/i/userpic/320/pengrad.jpg&auth_date=1560837746&hash=b00e1b82fdea0718efc02ee645286fbb0c986526dba9b4bb4d51753960feda04";
        CheckTelegramAuth checkTelegramAuth = CheckTelegramAuth.fromUrl(token(), data);
        assertTrue(checkTelegramAuth.isFromTelegram());
        assertEquals(new Date(1560837746000L), checkTelegramAuth.authDate());
    }

}

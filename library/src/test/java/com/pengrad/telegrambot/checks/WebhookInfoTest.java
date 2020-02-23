package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.WebhookInfo;

import static org.junit.Assert.*;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class WebhookInfoTest {

    public static void check(WebhookInfo webhookInfo) {
        assertNotNull(webhookInfo.url());
        assertFalse(webhookInfo.hasCustomCertificate());
        assertTrue(webhookInfo.pendingUpdateCount() >= 0);
    }

}

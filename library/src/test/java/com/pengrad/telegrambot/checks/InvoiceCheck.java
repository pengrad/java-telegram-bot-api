package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.Invoice;

import static org.junit.Assert.assertNotNull;

/**
 * Stas Parshin
 * 25 May 2017
 */
public class InvoiceCheck {

    public static void check(Invoice invoice) {
        assertNotNull(invoice.title());
        assertNotNull(invoice.description());
        assertNotNull(invoice.startParameter());
        assertNotNull(invoice.currency());
        assertNotNull(invoice.totalAmount());
    }

}

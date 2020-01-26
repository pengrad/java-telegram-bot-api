package com.pengrad.telegrambot;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Stas Parshin
 * 26 January 2020
 */
public class AttachNameTest {

    @Test
    public void next() {
        assertEquals("attach1", AttachName.next());
        assertEquals("attach2", AttachName.next());
        assertEquals("attach3", AttachName.next());
        assertEquals("attach4", AttachName.next());
        assertEquals("attach5", AttachName.next());
    }
}
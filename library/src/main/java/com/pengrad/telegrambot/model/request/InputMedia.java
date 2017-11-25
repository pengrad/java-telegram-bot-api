package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Stas Parshin
 * 23 November 2017
 */
abstract public class InputMedia implements Serializable {
    private final static long serialVersionUID = 0L;

    private static final AtomicInteger counter = new AtomicInteger();

    private final String type;
    private final String media;
    transient private Map<String, Object> attachments;

    public InputMedia(String type, Object media) {
        this.type = type;
        if (media instanceof String) {
            this.media = (String) media;
        } else {
            String attachName = "inputMedia" + nextId();
            this.media = "attach://" + attachName;
            if (attachments == null) {
                attachments = new HashMap<String, Object>();
            }
            attachments.put(attachName, media);
        }
    }

    private int nextId() {
        return counter.incrementAndGet();
    }

    // Nullable
    public Map<String, Object> getAttachments() {
        return attachments;
    }
}

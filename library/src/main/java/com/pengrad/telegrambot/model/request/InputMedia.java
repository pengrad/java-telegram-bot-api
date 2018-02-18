package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Stas Parshin
 * 23 November 2017
 */
abstract public class InputMedia<T extends InputMedia> implements Serializable {
    private final static long serialVersionUID = 0L;

    private static final AtomicInteger counter = new AtomicInteger();

    @SuppressWarnings("unchecked")
    private final T thisAsT = (T) this;

    private final String type;
    private final String media;
    transient private Map<String, Object> attachments;

    private String caption;
    private String parse_mode;

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

    public T caption(String caption) {
        this.caption = caption;
        return thisAsT;
    }

    public T parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return thisAsT;
    }
}

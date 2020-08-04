package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.AttachName;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Stas Parshin
 * 23 November 2017
 */
abstract public class InputMedia<T extends InputMedia<T>> implements Serializable {
    private final static long serialVersionUID = 0L;

    @SuppressWarnings("unchecked")
    private final T thisAsT = (T) this;

    private final String type;
    private final String media;
    private String thumb;
    private String caption;
    private String parse_mode;

    transient private Map<String, Object> attachments = new HashMap<>();
    transient private String filename;

    InputMedia(String type, Object media) {
        this.type = type;
        if (media instanceof String) {
            this.media = (String) media;
        } else {
            String attachName = AttachName.next();
            this.media = "attach://" + attachName;
            attachments.put(attachName, media);
            if (media instanceof File) {
                filename = ((File) media).getName();
            }
        }
    }

    public Map<String, Object> getAttachments() {
        return attachments;
    }

    public T thumb(File thumb) {
        String attachName = AttachName.next();
        attachments.put(attachName, thumb);
        this.thumb = "attach://" + attachName;
        return thisAsT;
    }

    public T thumb(byte[] thumb) {
        String attachName = AttachName.next();
        attachments.put(attachName, thumb);
        this.thumb = "attach://" + attachName;
        return thisAsT;
    }

    public T caption(String caption) {
        this.caption = caption;
        return thisAsT;
    }

    public T parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return thisAsT;
    }

    public String getFileName() {
        return filename != null ? filename : getDefaultFileName();
    }

    abstract protected String getDefaultFileName();

    abstract public String getContentType();
}

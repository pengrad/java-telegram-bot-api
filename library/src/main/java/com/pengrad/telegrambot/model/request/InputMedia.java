package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.AttachName;
import com.pengrad.telegrambot.model.MessageEntity;

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
    private String thumbnail;
    private Boolean show_caption_above_media;

    private String caption;
    private String parse_mode;
    private MessageEntity[] caption_entities;

    transient private Map<String, Object> attachments = new HashMap<>();
    transient private InputFile inputFile;
    transient private String inputFileAttachId;
    transient private String fileName;
    transient private String contentType;

    InputMedia(String type, Object media) {
        this.type = type;
        if (media instanceof String) {
            this.media = (String) media;
        } else {
            String attachName = AttachName.next();
            this.media = "attach://" + attachName;
            inputFileAttachId = attachName;
            if (media instanceof File) {
                fileName = ((File) media).getName();
                inputFile = new InputFile((File) media, getFileName(), getContentType());
            } else if (media instanceof byte[]) {
                inputFile = new InputFile((byte[]) media, getFileName(), getContentType());
            }
        }
    }

    public Map<String, Object> getAttachments() {
        return attachments;
    }

    public InputFile inputFile() {
        return inputFile;
    }

    public String getInputFileId() {
        return inputFileAttachId;
    }

    /**
     * @deprecated Use thumbnail instead
     */
    @Deprecated
    public T thumb(File thumb) {
        String attachName = AttachName.next();
        attachments.put(attachName, thumb);
        this.thumbnail = "attach://" + attachName;
        return thisAsT;
    }

    public T showCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        this.show_caption_above_media = showCaptionAboveMedia;
        return thisAsT;
    }

    /**
     * @deprecated Use thumbnail instead
     */
    @Deprecated
    public T thumb(byte[] thumb) {
        String attachName = AttachName.next();
        attachments.put(attachName, thumb);
        this.thumbnail = "attach://" + attachName;
        return thisAsT;
    }

    public T thumbnail(File thumbnail) {
        String attachName = AttachName.next();
        attachments.put(attachName, thumbnail);
        this.thumbnail = "attach://" + attachName;
        return thisAsT;
    }

    public T thumbnail(byte[] thumbnail) {
        String attachName = AttachName.next();
        attachments.put(attachName, thumbnail);
        this.thumbnail = "attach://" + attachName;
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

    public T captionEntities(MessageEntity... entities) {
        this.caption_entities = entities;
        return thisAsT;
    }

    public T fileName(String fileName) {
        if (inputFile != null) {
            inputFile.setFileName(fileName);
        }
        this.fileName = fileName;
        return thisAsT;
    }

    public T contentType(String contentType) {
        if (inputFile != null) {
            inputFile.setContentType(contentType);
        }
        this.contentType = contentType;
        return thisAsT;
    }

    public String getFileName() {
        return (fileName != null && !fileName.isEmpty()) ? fileName : getDefaultFileName();
    }

    public String getContentType() {
        return (contentType != null && !contentType.isEmpty()) ? contentType : getDefaultContentType();
    }

    abstract protected String getDefaultFileName();

    abstract protected String getDefaultContentType();
}

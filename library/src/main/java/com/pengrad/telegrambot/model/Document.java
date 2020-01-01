package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * stas
 * 8/5/15.
 */
public class Document implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private String file_unique_id;
    private PhotoSize thumb;
    private String file_name;
    private String mime_type;
    private Integer file_size;

    public String fileId() {
        return file_id;
    }

    public String fileUniqueId() {
        return file_unique_id;
    }

    public PhotoSize thumb() {
        return thumb;
    }

    public String fileName() {
        return file_name;
    }

    public String mimeType() {
        return mime_type;
    }

    public Integer fileSize() {
        return file_size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (file_id != null ? !file_id.equals(document.file_id) : document.file_id != null) return false;
        if (file_unique_id != null ? !file_unique_id.equals(document.file_unique_id) : document.file_unique_id != null)
            return false;
        if (thumb != null ? !thumb.equals(document.thumb) : document.thumb != null) return false;
        if (file_name != null ? !file_name.equals(document.file_name) : document.file_name != null) return false;
        if (mime_type != null ? !mime_type.equals(document.mime_type) : document.mime_type != null) return false;
        return file_size != null ? file_size.equals(document.file_size) : document.file_size == null;
    }

    @Override
    public int hashCode() {
        return file_id != null ? file_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Document{" +
                "file_id='" + file_id + '\'' +
                ", file_unique_id='" + file_unique_id + '\'' +
                ", thumb=" + thumb +
                ", file_name='" + file_name + '\'' +
                ", mime_type='" + mime_type + '\'' +
                ", file_size=" + file_size +
                '}';
    }
}

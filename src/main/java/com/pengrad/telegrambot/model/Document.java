package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/5/15.
 */
public class Document {

    private final String file_id;
    private final PhotoSize thumb;
    private final String file_name;
    private final String mime_type;
    private final Integer file_size;

    public Document(String file_id, PhotoSize thumb, String file_name, String mime_type, Integer file_size) {
        this.file_id = file_id;
        this.thumb = thumb;
        this.file_name = file_name;
        this.mime_type = mime_type;
        this.file_size = file_size;
    }

    public String fileId() {
        return file_id;
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

        if (!file_id.equals(document.file_id)) return false;
        if (thumb != null ? !thumb.equals(document.thumb) : document.thumb != null) return false;
        if (file_name != null ? !file_name.equals(document.file_name) : document.file_name != null) return false;
        if (mime_type != null ? !mime_type.equals(document.mime_type) : document.mime_type != null) return false;
        return !(file_size != null ? !file_size.equals(document.file_size) : document.file_size != null);

    }

    @Override
    public int hashCode() {
        return file_id.hashCode();
    }

    @Override
    public String toString() {
        return "Document{" +
                "file_id='" + file_id + '\'' +
                ", thumb=" + thumb +
                ", file_name='" + file_name + '\'' +
                ", mime_type='" + mime_type + '\'' +
                ", file_size=" + file_size +
                '}';
    }
}

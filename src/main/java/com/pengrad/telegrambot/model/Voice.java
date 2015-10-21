package com.pengrad.telegrambot.model;

/**
 * stas
 * 10/21/15.
 */
public class Voice {

    private final String file_id;
    private final Integer duration;
    private final String mime_type;
    private final Integer file_size;

    public Voice(String file_id, Integer duration, String mime_type, Integer file_size) {
        this.file_id = file_id;
        this.duration = duration;
        this.mime_type = mime_type;
        this.file_size = file_size;
    }

    public String fileId() {
        return file_id;
    }

    public Integer duration() {
        return duration;
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

        Voice voice = (Voice) o;

        if (!file_id.equals(voice.file_id)) return false;
        if (!duration.equals(voice.duration)) return false;
        if (mime_type != null ? !mime_type.equals(voice.mime_type) : voice.mime_type != null) return false;
        return !(file_size != null ? !file_size.equals(voice.file_size) : voice.file_size != null);

    }

    @Override
    public int hashCode() {
        return file_id.hashCode();
    }

    @Override
    public String toString() {
        return "Voice{" +
                "file_id='" + file_id + '\'' +
                ", duration=" + duration +
                ", mime_type='" + mime_type + '\'' +
                ", file_size=" + file_size +
                '}';
    }
}
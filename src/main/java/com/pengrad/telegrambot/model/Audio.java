package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/5/15.
 */
public class Audio {

    private final String file_id;
    private final Integer duration;
    private final String performer;
    private final String title;
    private final String mime_type;
    private final Integer file_size;

    public Audio(String file_id, Integer duration, String performer, String title, String mime_type, Integer filesize) {
        this.file_id = file_id;
        this.duration = duration;
        this.performer = performer;
        this.title = title;
        this.mime_type = mime_type;
        this.file_size = filesize;
    }

    public String fileId() {
        return file_id;
    }

    public Integer duration() {
        return duration;
    }

    public String performer() {
        return performer;
    }

    public String title() {
        return title;
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

        Audio audio = (Audio) o;

        if (!file_id.equals(audio.file_id)) return false;
        if (!duration.equals(audio.duration)) return false;
        if (performer != null ? !performer.equals(audio.performer) : audio.performer != null) return false;
        if (title != null ? !title.equals(audio.title) : audio.title != null) return false;
        if (mime_type != null ? !mime_type.equals(audio.mime_type) : audio.mime_type != null) return false;
        return !(file_size != null ? !file_size.equals(audio.file_size) : audio.file_size != null);

    }

    @Override
    public int hashCode() {
        return file_id.hashCode();
    }

    @Override
    public String toString() {
        return "Audio{" +
                "file_id='" + file_id + '\'' +
                ", duration=" + duration +
                ", performer='" + performer + '\'' +
                ", title='" + title + '\'' +
                ", mime_type='" + mime_type + '\'' +
                ", file_size=" + file_size +
                '}';
    }
}

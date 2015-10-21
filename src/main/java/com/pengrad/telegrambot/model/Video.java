package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/5/15.
 */
public class Video {

    private final String file_id;
    private final Integer width;
    private final Integer height;
    private final Integer duration;
    private final PhotoSize thumb;
    private final String mime_type;
    private final Integer file_size;

    public Video(String file_id, Integer width, Integer height, Integer duration, PhotoSize thumb, String mime_type,
                 Integer file_size) {
        this.file_id = file_id;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.thumb = thumb;
        this.mime_type = mime_type;
        this.file_size = file_size;
    }

    public String fileId() {
        return file_id;
    }

    public Integer width() {
        return width;
    }

    public Integer height() {
        return height;
    }

    public Integer duration() {
        return duration;
    }

    public PhotoSize thumb() {
        return thumb;
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

        Video video = (Video) o;

        if (!file_id.equals(video.file_id)) return false;
        if (!width.equals(video.width)) return false;
        if (!height.equals(video.height)) return false;
        if (!duration.equals(video.duration)) return false;
        if (thumb != null ? !thumb.equals(video.thumb) : video.thumb != null) return false;
        if (mime_type != null ? !mime_type.equals(video.mime_type) : video.mime_type != null) return false;
        return !(file_size != null ? !file_size.equals(video.file_size) : video.file_size != null);

    }

    @Override
    public int hashCode() {
        return file_id.hashCode();
    }

    @Override
    public String toString() {
        return "Video{" +
                "file_id='" + file_id + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", mime_type='" + mime_type + '\'' +
                ", file_size=" + file_size +
                '}';
    }
}

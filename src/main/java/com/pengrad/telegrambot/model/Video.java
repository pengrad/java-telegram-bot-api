package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/5/15.
 */
public class Video {

    private String file_id;
    private Integer width;
    private Integer height;
    private Integer duration;
    private PhotoSize thumb;
    private String mime_type;
    private Integer file_size;

    Video() {
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

        if (file_id != null ? !file_id.equals(video.file_id) : video.file_id != null) return false;
        if (width != null ? !width.equals(video.width) : video.width != null) return false;
        if (height != null ? !height.equals(video.height) : video.height != null) return false;
        if (duration != null ? !duration.equals(video.duration) : video.duration != null) return false;
        if (thumb != null ? !thumb.equals(video.thumb) : video.thumb != null) return false;
        if (mime_type != null ? !mime_type.equals(video.mime_type) : video.mime_type != null) return false;
        return file_size != null ? file_size.equals(video.file_size) : video.file_size == null;
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

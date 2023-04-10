package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class Animation implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private String file_unique_id;
    private Integer width;
    private Integer height;
    private Integer duration;
    private PhotoSize thumbnail;  
    private String file_name;
    private String mime_type;
    private Long file_size;

    public String fileId() {
        return file_id;
    }

    public String fileUniqueId() {
        return file_unique_id;
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

    public PhotoSize thumbnail() {
        return thumbnail;
    }

    /**
     * @deprecated Use thumbnail instead
     */
    @Deprecated 
    public PhotoSize thumb() {
        return thumbnail();
    }

    public String fileName() {
        return file_name;
    }

    public String mimeType() {
        return mime_type;
    }

    public Long fileSize() {
        return file_size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animation animation = (Animation) o;

        if (file_id != null ? !file_id.equals(animation.file_id) : animation.file_id != null) return false;
        if (file_unique_id != null ? !file_unique_id.equals(animation.file_unique_id) : animation.file_unique_id != null)
            return false;
        if (width != null ? !width.equals(animation.width) : animation.width != null) return false;
        if (height != null ? !height.equals(animation.height) : animation.height != null) return false;
        if (duration != null ? !duration.equals(animation.duration) : animation.duration != null) return false;
        if (thumbnail != null ? !thumbnail.equals(animation.thumbnail) : animation.thumbnail != null) return false;
        if (file_name != null ? !file_name.equals(animation.file_name) : animation.file_name != null) return false;
        if (mime_type != null ? !mime_type.equals(animation.mime_type) : animation.mime_type != null) return false;
        return file_size != null ? file_size.equals(animation.file_size) : animation.file_size == null;
    }

    @Override
    public int hashCode() {
        return file_id != null ? file_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Animation{" +
                "file_id='" + file_id + '\'' +
                ", file_unique_id='" + file_unique_id + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumbnail=" + thumbnail +
                ", file_name='" + file_name + '\'' +
                ", mime_type='" + mime_type + '\'' +
                ", file_size=" + file_size +
                '}';
    }
}

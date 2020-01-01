package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * stas
 * 8/5/15.
 */
public class Sticker implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private String file_unique_id;
    private Integer width;
    private Integer height;
    private Boolean is_animated;
    private PhotoSize thumb;
    private String emoji;
    private String set_name;
    private MaskPosition mask_position;
    private Integer file_size;

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

    public Boolean isAnimated() {
        return is_animated;
    }

    public PhotoSize thumb() {
        return thumb;
    }

    public String emoji() {
        return emoji;
    }

    public String setName() {
        return set_name;
    }

    public MaskPosition maskPosition() {
        return mask_position;
    }

    public Integer fileSize() {
        return file_size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sticker sticker = (Sticker) o;

        if (file_id != null ? !file_id.equals(sticker.file_id) : sticker.file_id != null) return false;
        if (file_unique_id != null ? !file_unique_id.equals(sticker.file_unique_id) : sticker.file_unique_id != null)
            return false;
        if (width != null ? !width.equals(sticker.width) : sticker.width != null) return false;
        if (height != null ? !height.equals(sticker.height) : sticker.height != null) return false;
        if (is_animated != null ? !is_animated.equals(sticker.is_animated) : sticker.is_animated != null) return false;
        if (thumb != null ? !thumb.equals(sticker.thumb) : sticker.thumb != null) return false;
        if (emoji != null ? !emoji.equals(sticker.emoji) : sticker.emoji != null) return false;
        if (set_name != null ? !set_name.equals(sticker.set_name) : sticker.set_name != null) return false;
        if (mask_position != null ? !mask_position.equals(sticker.mask_position) : sticker.mask_position != null) return false;
        return file_size != null ? file_size.equals(sticker.file_size) : sticker.file_size == null;
    }

    @Override
    public int hashCode() {
        return file_id != null ? file_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "file_id='" + file_id + '\'' +
                ", file_unique_id='" + file_unique_id + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", is_animated=" + is_animated +
                ", thumb=" + thumb +
                ", emoji='" + emoji + '\'' +
                ", set_name='" + set_name + '\'' +
                ", mask_position=" + mask_position +
                ", file_size=" + file_size +
                '}';
    }
}

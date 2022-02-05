package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class StickerSet implements Serializable {
    private final static long serialVersionUID = 0L;

    private String name;
    private String title;
    private Boolean is_animated;
    private Boolean is_video;
    private Boolean contains_masks;
    private Sticker[] stickers;
    private PhotoSize thumb;

    public String name() {
        return name;
    }

    public String title() {
        return title;
    }

    public Boolean isAnimated() {
        return is_animated;
    }

    public Boolean containsMasks() {
        return contains_masks;
    }

    public Sticker[] stickers() {
        return stickers;
    }

    public PhotoSize thumb() {
        return thumb;
    }

    public Boolean isVideo() {
        return is_video;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StickerSet that = (StickerSet) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(title, that.title) &&
                Objects.equals(is_animated, that.is_animated) &&
                Objects.equals(is_video, that.is_video) &&
                Objects.equals(contains_masks, that.contains_masks) &&
                Arrays.equals(stickers, that.stickers) &&
                Objects.equals(thumb, that.thumb);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, title, is_animated, is_video, contains_masks, thumb);
        result = 31 * result + Arrays.hashCode(stickers);
        return result;
    }

    @Override
    public String toString() {
        return "StickerSet{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", is_animated=" + is_animated +
                ", is_video=" + is_video +
                ", contains_masks=" + contains_masks +
                ", stickers=" + Arrays.toString(stickers) +
                ", thumb=" + thumb +
                '}';
    }
}

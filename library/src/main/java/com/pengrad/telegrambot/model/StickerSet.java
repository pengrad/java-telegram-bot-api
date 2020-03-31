package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class StickerSet implements Serializable {
    private final static long serialVersionUID = 0L;

    private String name;
    private String title;
    private Boolean is_animated;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StickerSet that = (StickerSet) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (is_animated != null ? !is_animated.equals(that.is_animated) : that.is_animated != null) return false;
        if (contains_masks != null ? !contains_masks.equals(that.contains_masks) : that.contains_masks != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(stickers, that.stickers)) return false;
        if (thumb != null ? !thumb.equals(that.thumb) : that.thumb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (is_animated != null ? is_animated.hashCode() : 0);
        result = 31 * result + (contains_masks != null ? contains_masks.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(stickers);
        result = 31 * result + (thumb != null ? thumb.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StickerSet{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", is_animated=" + is_animated +
                ", contains_masks=" + contains_masks +
                ", stickers=" + Arrays.toString(stickers) +
                ", thumb=" + thumb +
                '}';
    }
}

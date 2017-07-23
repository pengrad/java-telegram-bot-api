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
    private Boolean contains_masks;
    private Sticker[] stickers;

    public String name() {
        return name;
    }

    public String title() {
        return title;
    }

    public Boolean containsMasks() {
        return contains_masks;
    }

    public Sticker[] stickers() {
        return stickers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StickerSet that = (StickerSet) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (contains_masks != null ? !contains_masks.equals(that.contains_masks) : that.contains_masks != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(stickers, that.stickers);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (contains_masks != null ? contains_masks.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(stickers);
        return result;
    }

    @Override
    public String toString() {
        return "StickerSet{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", contains_masks=" + contains_masks +
                ", stickers=" + Arrays.toString(stickers) +
                '}';
    }
}

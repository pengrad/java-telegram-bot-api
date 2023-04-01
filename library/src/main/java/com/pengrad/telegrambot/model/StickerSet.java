package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import com.pengrad.telegrambot.model.Sticker.Type;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class StickerSet implements Serializable {
    private final static long serialVersionUID = 0L;

    private String name;
    private String title;
    private Type sticker_type;
    private Boolean is_animated;
    private Boolean is_video;
    private Boolean contains_masks;
    private Sticker[] stickers;
    private PhotoSize thumbnail;
  

    public String name() {
        return name;
    }

    public String title() {
        return title;
    }

    public Type stickerType() {
        return sticker_type;
    }

    public Boolean isAnimated() {
        return is_animated;
    }

    /** 
     *  @deprecated Use type() and check if it equals to Type.mask
     */   
    @Deprecated
    public Boolean containsMasks() {
        return contains_masks;
    }

    public Sticker[] stickers() {
        return stickers;
    }

    public PhotoSize thumbnail() {
        return thumbnail;
    }

    /**
     * @deprecated Use thumbnail instead
     */
    @Deprecated 
    public PhotoSize thumb() {
        return thumbnail;
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
                Objects.equals(sticker_type, that.sticker_type) &&
                Objects.equals(is_animated, that.is_animated) &&
                Objects.equals(is_video, that.is_video) &&
                Objects.equals(contains_masks, that.contains_masks) &&
                Arrays.equals(stickers, that.stickers) &&
                Objects.equals(thumbnail, that.thumbnail);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, title, sticker_type, is_animated, is_video, thumbnail);
        result = 31 * result + Arrays.hashCode(stickers);
        return result;
    }

    @Override
    public String toString() {
        return "StickerSet{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", sticker_type='" + sticker_type + '\'' +
                ", is_animated=" + is_animated +
                ", is_video=" + is_video +
                ", contains_masks=" + contains_masks +
                ", stickers=" + Arrays.toString(stickers) +
                ", thumbnail=" + thumbnail +
                '}';
    }
}

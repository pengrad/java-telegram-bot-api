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

    public Sticker[] stickers() {
        return stickers;
    }

    public PhotoSize thumbnail() {
        return thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StickerSet that = (StickerSet) o;
        return Objects.equals(name, that.name) && Objects.equals(title, that.title) && sticker_type == that.sticker_type && Arrays.equals(stickers, that.stickers) && Objects.equals(thumbnail, that.thumbnail);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, title, sticker_type, thumbnail);
        result = 31 * result + Arrays.hashCode(stickers);
        return result;
    }

    @Override
    public String toString() {
        return "StickerSet{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", sticker_type=" + sticker_type +
                ", stickers=" + Arrays.toString(stickers) +
                ", thumbnail=" + thumbnail +
                '}';
    }
}

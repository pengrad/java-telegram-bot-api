package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

public class LinkPreviewOptions implements Serializable {

    private final static long serialVersionUID = 0L;


    private Boolean is_disabled;
    private String url;
    private Boolean prefer_small_media;
    private Boolean prefer_large_media;
    private Boolean show_above_text;


    public Boolean isDisabled() {
        return is_disabled;
    }

    public String url() {
        return url;
    }

    public Boolean preferSmallMedia() {
        return prefer_small_media;
    }

    public Boolean preferLargeMedia() {
        return prefer_large_media;
    }

    public Boolean showAboveText() {
        return show_above_text;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkPreviewOptions that = (LinkPreviewOptions) o;
        return Objects.equals(is_disabled, that.is_disabled)
                && Objects.equals(url, that.url)
                && Objects.equals(prefer_small_media, that.prefer_small_media)
                && Objects.equals(prefer_large_media, that.prefer_large_media)
                && Objects.equals(show_above_text, that.show_above_text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(is_disabled, url, prefer_small_media, prefer_large_media, show_above_text);
    }

    @Override
    public String toString() {
        return "LinkPreviewOptions{" +
                "is_disabled='" + is_disabled + "'," +
                "url='" + url + "'," +
                "prefer_small_media='" + prefer_small_media + "'," +
                "prefer_large_media='" + prefer_large_media + "'," +
                "show_above_text='" + show_above_text + "'" +
                '}';
    }

}

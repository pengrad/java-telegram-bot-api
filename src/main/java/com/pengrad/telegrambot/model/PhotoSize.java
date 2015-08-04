package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class PhotoSize {

    public final String file_id;
    public final Integer width;
    public final Integer height;
    public final Integer file_size;

    public PhotoSize(String file_id, Integer width, Integer height, Integer file_size) {
        this.file_id = file_id;
        this.width = width;
        this.height = height;
        this.file_size = file_size;
    }
}

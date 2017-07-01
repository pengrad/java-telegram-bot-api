package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class ChatPhoto implements Serializable {
    private final static long serialVersionUID = 0L;

    private String small_file_id;
    private String big_file_id;

    public String smallFileId() {
        return small_file_id;
    }

    public String bigFileId() {
        return big_file_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatPhoto chatPhoto = (ChatPhoto) o;

        if (small_file_id != null ? !small_file_id.equals(chatPhoto.small_file_id) : chatPhoto.small_file_id != null)
            return false;
        return big_file_id != null ? big_file_id.equals(chatPhoto.big_file_id) : chatPhoto.big_file_id == null;
    }

    @Override
    public int hashCode() {
        int result = small_file_id != null ? small_file_id.hashCode() : 0;
        result = 31 * result + (big_file_id != null ? big_file_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatPhoto{" +
                "small_file_id='" + small_file_id + '\'' +
                ", big_file_id='" + big_file_id + '\'' +
                '}';
    }
}

package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/**
 * Stas Parshin
 * 30 July 2018
 */
public class PassportFile implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private String file_unique_id;
    private Integer file_size;
    private Integer file_date;

    public String fileId() {
        return file_id;
    }

    public String fileUniqueId() {
        return file_unique_id;
    }

    public Integer fileSize() {
        return file_size;
    }

    public Integer fileDate() {
        return file_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassportFile that = (PassportFile) o;

        if (file_id != null ? !file_id.equals(that.file_id) : that.file_id != null) return false;
        if (file_unique_id != null ? !file_unique_id.equals(that.file_unique_id) : that.file_unique_id != null) return false;
        if (file_size != null ? !file_size.equals(that.file_size) : that.file_size != null) return false;
        return file_date != null ? file_date.equals(that.file_date) : that.file_date == null;
    }

    @Override
    public int hashCode() {
        return file_id != null ? file_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PassportFile{" +
                "file_id='" + file_id + '\'' +
                ", file_unique_id='" + file_unique_id + '\'' +
                ", file_size=" + file_size +
                ", file_date=" + file_date +
                '}';
    }
}

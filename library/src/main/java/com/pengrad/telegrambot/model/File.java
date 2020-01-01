package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class File implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private String file_unique_id;
    private Integer file_size;
    private String file_path;

    public String fileId() {
        return file_id;
    }

    public String fileUniqueId() {
        return file_unique_id;
    }

    public Integer fileSize() {
        return file_size;
    }

    public String filePath() {
        return file_path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (file_id != null ? !file_id.equals(file.file_id) : file.file_id != null) return false;
        if (file_unique_id != null ? !file_unique_id.equals(file.file_unique_id) : file.file_unique_id != null) return false;
        if (file_size != null ? !file_size.equals(file.file_size) : file.file_size != null) return false;
        return file_path != null ? file_path.equals(file.file_path) : file.file_path == null;
    }

    @Override
    public int hashCode() {
        return file_id != null ? file_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "File{" +
                "file_id='" + file_id + '\'' +
                ", file_unique_id='" + file_unique_id + '\'' +
                ", file_size=" + file_size +
                ", file_path='" + file_path + '\'' +
                '}';
    }
}

package com.pengrad.telegrambot.model.request;

import java.io.File;

public class InputFile {

    private File file;
    private byte[] bytes;
    private String fileName;
    private String contentType;

    public InputFile(File file, String fileName, String contentType) {
        this.file = file;
        this.fileName = fileName;
        this.contentType = contentType;
    }

    public InputFile(byte[] bytes, String fileName, String contentType) {
        this.bytes = bytes;
        this.fileName = fileName;
        this.contentType = contentType;
    }

    public File getFile() {
        return file;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }

    void setContentType(String contentType) {
        this.contentType = contentType;
    }
}

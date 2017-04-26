package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * stas
 * 10/21/15.
 */
public enum ChatAction implements Serializable {
    typing, upload_photo, record_video, upload_video, record_audio, upload_audio, upload_document, find_location;
    private final static long serialVersionUID = 0L;
}

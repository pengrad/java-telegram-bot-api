package com.pengrad.telegrambot.model.request

/**
 * stas
 * 10/21/15.
 */
@Suppress("EnumEntryName")
enum class ChatAction {
    typing,
    upload_photo,
    record_video,
    upload_video,
    record_voice,
    upload_voice,
    upload_document,
    choose_sticker,
    find_location,
    record_video_note,
    upload_video_note
}

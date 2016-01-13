package com.pengrad.telegrambot.model.request;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultVideo extends InlineQueryResult {

    public static final String MIME_TEXT_HTML = "text/html";
    public static final String MIME_VIDEO_MP4 = "video/mp4";

    private String type;
    private String id;
    private String video_url;
    private String mime_type;
    private String message_text;
    private String thumb_url;
    private String title;

    private ParseMode parse_mode;
    private Boolean disable_web_page_preview;
    private Integer video_width;
    private Integer video_height;
    private Integer video_duration;
    private String description;

    public InlineQueryResultVideo(String id, String videoUrl, String mimeType, String messageText, String thumbUrl, String title) {
        this.type = "video";
        this.id = id;
        this.video_url = videoUrl;
        this.mime_type = mimeType;
        this.message_text = messageText;
        this.thumb_url = thumbUrl;
        this.title = title;
    }

    public InlineQueryResultVideo parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode;
        return this;
    }

    public InlineQueryResultVideo disableWebPagePreview(Boolean disableWebPagePreview) {
        this.disable_web_page_preview = disableWebPagePreview;
        return this;
    }

    public InlineQueryResultVideo videoWidth(Integer videoWidth) {
        this.video_width = videoWidth;
        return this;
    }

    public InlineQueryResultVideo videoHeight(Integer videoHeight) {
        this.video_height = videoHeight;
        return this;
    }

    public void videoDuration(Integer videoDuration) {
        this.video_duration = videoDuration;
    }

    public InlineQueryResultVideo description(String description) {
        this.description = description;
        return this;
    }
}

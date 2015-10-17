package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class Video {

	private String fileId;
	private Integer width;
	private Integer height;
	private Integer duration;
	private PhotoSize thumb;
	private String mimeType;
	private Integer fileSize;

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(String fileId, Integer width, Integer height, Integer duration, PhotoSize thumb, String mimeType,
			Integer fileSize) {
		super();
		this.fileId = fileId;
		this.width = width;
		this.height = height;
		this.duration = duration;
		this.thumb = thumb;
		this.mimeType = mimeType;
		this.fileSize = fileSize;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public PhotoSize getThumb() {
		return thumb;
	}

	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
}

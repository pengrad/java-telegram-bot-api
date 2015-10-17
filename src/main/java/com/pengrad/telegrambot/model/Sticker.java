package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class Sticker {

	private String fileId;
	private Integer width;
	private Integer height;
	private PhotoSize thumb;
	private Integer fileSize;

	public Sticker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sticker(String fileId, Integer width, Integer height, PhotoSize thumb, Integer fileSize) {
		super();
		this.fileId = fileId;
		this.width = width;
		this.height = height;
		this.thumb = thumb;
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

	public PhotoSize getThumb() {
		return thumb;
	}

	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
}

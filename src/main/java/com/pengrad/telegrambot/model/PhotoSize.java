package com.pengrad.telegrambot.model;

/**
 * stas 8/4/15.
 */
public class PhotoSize {

	private String fileId;
	private Integer width;
	private Integer height;
	private Integer fileSize;

	public PhotoSize() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhotoSize(String fileId, Integer width, Integer height, Integer fileSize) {
		super();
		this.fileId = fileId;
		this.width = width;
		this.height = height;
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

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
}

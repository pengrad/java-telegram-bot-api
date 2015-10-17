package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class Audio {

	private String fileId;
	private Integer duration;
	private String mimeType;
	private Integer fileSize;

	public Audio() {
		super();
	}

	public Audio(String fileId, Integer duration, String mimeType, Integer fileSize) {
		super();
		this.fileId = fileId;
		this.duration = duration;
		this.mimeType = mimeType;
		this.fileSize = fileSize;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
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

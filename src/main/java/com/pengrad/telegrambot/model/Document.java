package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class Document {

	private String fileId;
	private PhotoSize thumb;
	private String fileName;
	private String mimeType;
	private Integer fileSize;

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(String fileId, PhotoSize thumb, String fileName, String mimeType, Integer fileSize) {
		super();
		this.fileId = fileId;
		this.thumb = thumb;
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.fileSize = fileSize;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public PhotoSize getThumb() {
		return thumb;
	}

	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

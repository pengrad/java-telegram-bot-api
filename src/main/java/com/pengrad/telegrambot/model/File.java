package com.pengrad.telegrambot.model;

/**
 * Stas Parshin 16 October 2015
 */
public class File {

	private String fileId;
	private Integer fileSize;
	private String filePath;

	public File() {
		super();
		// TODO Auto-generated constructor stub
	}

	public File(String fileId, Integer fileSize, String filePath) {
		super();
		this.fileId = fileId;
		this.fileSize = fileSize;
		this.filePath = filePath;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}

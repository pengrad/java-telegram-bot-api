package com.pengrad.telegrambot.model;

/**
 * Stas Parshin 16 October 2015
 */
public class File {

	private String file_id;
	private Integer file_size;
	private String file_path;

	public File() {
		super();
		// TODO Auto-generated constructor stub
	}

	public File(String fileId, Integer fileSize, String filePath) {
		super();
		this.file_id = fileId;
		this.file_size = fileSize;
		this.file_path = filePath;
	}

	public String getFileId() {
		return file_id;
	}

	public Integer getFileSize() {
		return file_size;
	}

	public String getFilePath() {
		return file_path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file_id == null) ? 0 : file_id.hashCode());
		result = prime * result + ((file_path == null) ? 0 : file_path.hashCode());
		result = prime * result + ((file_size == null) ? 0 : file_size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		if (file_id == null) {
			if (other.file_id != null)
				return false;
		} else if (!file_id.equals(other.file_id))
			return false;
		if (file_path == null) {
			if (other.file_path != null)
				return false;
		} else if (!file_path.equals(other.file_path))
			return false;
		if (file_size == null) {
			if (other.file_size != null)
				return false;
		} else if (!file_size.equals(other.file_size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "File [fileId=" + file_id + ", fileSize=" + file_size + ", filePath=" + file_path + "]";
	}
}

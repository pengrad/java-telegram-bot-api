package com.pengrad.telegrambot.model;

/**
 * stas 8/4/15.
 */
public class PhotoSize {

	private String file_id;
	private Integer width;
	private Integer height;
	private Integer file_size;

	public PhotoSize() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhotoSize(String fileId, Integer width, Integer height, Integer fileSize) {
		super();
		this.file_id = fileId;
		this.width = width;
		this.height = height;
		this.file_size = fileSize;
	}

	public String getFileId() {
		return file_id;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

	public Integer getFileSize() {
		return file_size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file_id == null) ? 0 : file_id.hashCode());
		result = prime * result + ((file_size == null) ? 0 : file_size.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
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
		PhotoSize other = (PhotoSize) obj;
		if (file_id == null) {
			if (other.file_id != null)
				return false;
		} else if (!file_id.equals(other.file_id))
			return false;
		if (file_size == null) {
			if (other.file_size != null)
				return false;
		} else if (!file_size.equals(other.file_size))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PhotoSize [fileId=" + file_id + ", width=" + width + ", height=" + height + ", fileSize=" + file_size
				+ "]";
	}
}

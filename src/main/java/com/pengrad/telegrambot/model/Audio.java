package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class Audio {

	private String file_id;
	private Integer duration;
	private String mime_type;
	private Integer file_size;

	public Audio() {
		super();
	}

	public Audio(String fileId, Integer duration, String mimeType, Integer fileSize) {
		super();
		this.file_id = fileId;
		this.duration = duration;
		this.mime_type = mimeType;
		this.file_size = fileSize;
	}

	public String getFileId() {
		return file_id;
	}

	public Integer getDuration() {
		return duration;
	}

	public String getMimeType() {
		return mime_type;
	}

	public Integer getFileSize() {
		return file_size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((file_id == null) ? 0 : file_id.hashCode());
		result = prime * result + ((file_size == null) ? 0 : file_size.hashCode());
		result = prime * result + ((mime_type == null) ? 0 : mime_type.hashCode());
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
		Audio other = (Audio) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
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
		if (mime_type == null) {
			if (other.mime_type != null)
				return false;
		} else if (!mime_type.equals(other.mime_type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Audio [fileId=" + file_id + ", duration=" + duration + ", mimeType=" + mime_type + ", fileSize="
				+ file_size + "]";
	}
}

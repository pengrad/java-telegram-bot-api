package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class Video {

	private String file_id;
	private Integer width;
	private Integer height;
	private Integer duration;
	private PhotoSize thumb;
	private String mime_type;
	private Integer file_size;

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(String fileId, Integer width, Integer height, Integer duration, PhotoSize thumb, String mimeType,
			Integer fileSize) {
		super();
		this.file_id = fileId;
		this.width = width;
		this.height = height;
		this.duration = duration;
		this.thumb = thumb;
		this.mime_type = mimeType;
		this.file_size = fileSize;
	}

	public String fileId() {
		return file_id;
	}

	public Integer width() {
		return width;
	}

	public Integer height() {
		return height;
	}

	public Integer duration() {
		return duration;
	}

	public PhotoSize thumb() {
		return thumb;
	}

	public String mimeType() {
		return mime_type;
	}

	public Integer fileSize() {
		return file_size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((file_id == null) ? 0 : file_id.hashCode());
		result = prime * result + ((file_size == null) ? 0 : file_size.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((mime_type == null) ? 0 : mime_type.hashCode());
		result = prime * result + ((thumb == null) ? 0 : thumb.hashCode());
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
		Video other = (Video) obj;
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
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (mime_type == null) {
			if (other.mime_type != null)
				return false;
		} else if (!mime_type.equals(other.mime_type))
			return false;
		if (thumb == null) {
			if (other.thumb != null)
				return false;
		} else if (!thumb.equals(other.thumb))
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
		return "Video [fileId=" + file_id + ", width=" + width + ", height=" + height + ", duration=" + duration
				+ ", thumb=" + thumb + ", mimeType=" + mime_type + ", fileSize=" + file_size + "]";
	}
}

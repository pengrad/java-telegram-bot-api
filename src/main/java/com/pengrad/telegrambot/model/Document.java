package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class Document {

	private String file_id;
	private PhotoSize thumb;
	private String file_name;
	private String mime_type;
	private Integer file_size;

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(String fileId, PhotoSize thumb, String fileName, String mimeType, Integer fileSize) {
		super();
		this.file_id = fileId;
		this.thumb = thumb;
		this.file_name = fileName;
		this.mime_type = mimeType;
		this.file_size = fileSize;
	}

	public String fileId() {
		return file_id;
	}

	public PhotoSize thumb() {
		return thumb;
	}

	public String fileName() {
		return file_name;
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
		result = prime * result + ((file_id == null) ? 0 : file_id.hashCode());
		result = prime * result + ((file_name == null) ? 0 : file_name.hashCode());
		result = prime * result + ((file_size == null) ? 0 : file_size.hashCode());
		result = prime * result + ((mime_type == null) ? 0 : mime_type.hashCode());
		result = prime * result + ((thumb == null) ? 0 : thumb.hashCode());
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
		Document other = (Document) obj;
		if (file_id == null) {
			if (other.file_id != null)
				return false;
		} else if (!file_id.equals(other.file_id))
			return false;
		if (file_name == null) {
			if (other.file_name != null)
				return false;
		} else if (!file_name.equals(other.file_name))
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
		if (thumb == null) {
			if (other.thumb != null)
				return false;
		} else if (!thumb.equals(other.thumb))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Document [fileId=" + file_id + ", thumb=" + thumb + ", fileName=" + file_name + ", mimeType="
				+ mime_type + ", fileSize=" + file_size + "]";
	}
}

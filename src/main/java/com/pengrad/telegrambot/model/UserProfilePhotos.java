package com.pengrad.telegrambot.model;

import java.util.Arrays;

/**
 * stas 8/5/15.
 */
public class UserProfilePhotos {

	private Integer total_count;
	private PhotoSize[][] photos;

	public UserProfilePhotos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfilePhotos(Integer totalCount, PhotoSize[][] photos) {
		super();
		this.total_count = totalCount;
		this.photos = photos;
	}

	public Integer totalCount() {
		return total_count;
	}

	public PhotoSize[][] photos() {
		return photos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(photos);
		result = prime * result + ((total_count == null) ? 0 : total_count.hashCode());
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
		UserProfilePhotos other = (UserProfilePhotos) obj;
		if (!Arrays.deepEquals(photos, other.photos))
			return false;
		if (total_count == null) {
			if (other.total_count != null)
				return false;
		} else if (!total_count.equals(other.total_count))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserProfilePhotos [totalCount=" + total_count + ", photos=" + Arrays.toString(photos) + "]";
	}
}
package com.pengrad.telegrambot.model;

import java.util.Arrays;

/**
 * stas 8/5/15.
 */
public class UserProfilePhotos {

	private Integer totalCount;
	private PhotoSize[][] photos;

	public UserProfilePhotos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfilePhotos(Integer totalCount, PhotoSize[][] photos) {
		super();
		this.totalCount = totalCount;
		this.photos = photos;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public PhotoSize[][] getPhotos() {
		return photos;
	}

	public void setPhotos(PhotoSize[][] photos) {
		this.photos = photos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(photos);
		result = prime * result + ((totalCount == null) ? 0 : totalCount.hashCode());
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
		if (totalCount == null) {
			if (other.totalCount != null)
				return false;
		} else if (!totalCount.equals(other.totalCount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserProfilePhotos [totalCount=" + totalCount + ", photos=" + Arrays.toString(photos) + "]";
	}
}
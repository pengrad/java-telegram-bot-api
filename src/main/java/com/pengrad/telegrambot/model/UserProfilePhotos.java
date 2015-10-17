package com.pengrad.telegrambot.model;

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
}
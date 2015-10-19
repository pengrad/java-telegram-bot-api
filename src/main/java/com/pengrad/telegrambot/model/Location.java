package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class Location {

	private Float longitude;
	private Float latitude;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(Float longitude, Float latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Float longitude() {
		return longitude;
	}

	public Float latitude() {
		return latitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
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
		Location other = (Location) obj;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [longitude=" + longitude + ", latitude=" + latitude + "]";
	}
}

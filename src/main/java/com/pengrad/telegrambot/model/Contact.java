package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class Contact {

	private String phone_number;
	private String first_name;
	private String last_name;
	private Integer user_id;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String phoneNumber, String firstName, String lastName, Integer userId) {
		super();
		this.phone_number = phoneNumber;
		this.first_name = firstName;
		this.last_name = lastName;
		this.user_id = userId;
	}

	public String phoneNumber() {
		return phone_number;
	}

	public String firstName() {
		return first_name;
	}

	public String lastName() {
		return last_name;
	}

	public Integer userId() {
		return user_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((phone_number == null) ? 0 : phone_number.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		Contact other = (Contact) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (phone_number == null) {
			if (other.phone_number != null)
				return false;
		} else if (!phone_number.equals(other.phone_number))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [phoneNumber=" + phone_number + ", firstName=" + first_name + ", lastName=" + last_name
				+ ", userId=" + user_id + "]";
	}
}

package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class UserOrGroupChat {

	private Integer id;

	// User
	private String first_name;
	private String last_name;
	private String username;

	// Group
	private String title;

	public UserOrGroupChat() {
		super();
	}

	public UserOrGroupChat(Integer id, String firstName, String lastName, String username, String title) {
		super();
		this.id = id;
		this.first_name = firstName;
		this.last_name = lastName;
		this.username = username;
		this.title = title;
	}

	public boolean isUser() {
		return first_name != null;
	}

	public Integer id() {
		return id;
	}

	public String firstName() {
		return first_name;
	}

	public String lastName() {
		return last_name;
	}

	public String userName() {
		return username;
	}

	public String title() {
		return title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserOrGroupChat other = (UserOrGroupChat) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserOrGroupChat [id=" + id + ", firstName=" + first_name + ", lastName=" + last_name + ", username="
				+ username + ", title=" + title + "]";
	}
}

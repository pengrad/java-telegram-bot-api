package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class GroupChat {

	private Integer id;
	private String title;

	public GroupChat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupChat(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		GroupChat other = (GroupChat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroupChat [id=" + id + ", title=" + title + "]";
	}
}

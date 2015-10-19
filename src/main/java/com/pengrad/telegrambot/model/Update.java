package com.pengrad.telegrambot.model;

/**
 * stas 8/4/15.
 */
public class Update {

	private Integer update_id;
	private Message message;

	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Update(Integer updateId, Message message) {
		super();
		this.update_id = updateId;
		this.message = message;
	}

	public Integer updateId() {
		return update_id;
	}

	public Message message() {
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((update_id == null) ? 0 : update_id.hashCode());
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
		Update other = (Update) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (update_id == null) {
			if (other.update_id != null)
				return false;
		} else if (!update_id.equals(other.update_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Update [updateId=" + update_id + ", message=" + message + "]";
	}
}

package com.pengrad.telegrambot.model;

/**
 * stas 8/4/15.
 */
public class Update {

	private Integer updateId;
	private Message message;

	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Update(Integer updateId, Message message) {
		super();
		this.updateId = updateId;
		this.message = message;
	}

	public Integer getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((updateId == null) ? 0 : updateId.hashCode());
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
		if (updateId == null) {
			if (other.updateId != null)
				return false;
		} else if (!updateId.equals(other.updateId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Update [updateId=" + updateId + ", message=" + message + "]";
	}
}

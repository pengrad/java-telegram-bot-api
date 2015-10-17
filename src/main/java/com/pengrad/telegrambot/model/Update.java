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
}

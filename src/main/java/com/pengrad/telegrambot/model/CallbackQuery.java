package com.pengrad.telegrambot.model;


public class CallbackQuery {

	private String id;
	private User from;
	private Message message;
	private String inline_message_id;
	private String data;
	
	public String getId() {
	
		return id;
	}
	
	public void setId(
			String id ) {
	
		this.id = id;
	}
	
	public User getFrom() {
	
		return from;
	}
	
	public void setFrom(
			User from ) {
	
		this.from = from;
	}
	
	public Message getMessage() {
	
		return message;
	}
	
	public void setMessage(
			Message message ) {
	
		this.message = message;
	}
	
	public String getInline_message_id() {
	
		return inline_message_id;
	}
	
	public void setInline_message_id(
			String inline_message_id ) {
	
		this.inline_message_id = inline_message_id;
	}
	
	public String getData() {
	
		return data;
	}
	
	public void setData(
			String data ) {
	
		this.data = data;
	}
	
}

package com.pengrad.telegrambot.model.request;

public class KeyboardButton {

	private String text;
	private boolean request_contact;
	private boolean request_location;

	public KeyboardButton( String text, boolean requestContact, boolean requestLocation ) {

		this.text = text;
		this.request_contact = requestContact;
		this.request_location = requestLocation;
	}

	public String getText() {

		return text;
	}

	public void setText(
			String text ) {

		this.text = text;
	}

	public boolean isRequest_contact() {

		return request_contact;
	}

	public void setRequest_contact(
			boolean request_contact ) {

		this.request_contact = request_contact;
	}

	public boolean isRequest_location() {

		return request_location;
	}

	public void setRequest_location(
			boolean request_location ) {

		this.request_location = request_location;
	}

}

package com.pengrad.telegrambot.model;

/**
 * stas 8/5/15.
 */
public class Contact {

	private String phoneNumber;
	private String firstName;
	private String lastName;
	private Integer userId;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String phoneNumber, String firstName, String lastName, Integer userId) {
		super();
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}

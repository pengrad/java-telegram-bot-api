package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/5/15.
 */
public class UserOrGroupChat {

    private Integer id;

    //User
    private String firstName;
    private String lastName;
    private String username;

	//Group
    private String title;
    
    public UserOrGroupChat() {
		super();
	}

	public UserOrGroupChat(Integer id, String firstName, String lastName, String username, String title) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.title = title;
	}



	public boolean isUser() {
        return firstName != null;
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

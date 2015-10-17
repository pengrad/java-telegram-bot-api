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

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

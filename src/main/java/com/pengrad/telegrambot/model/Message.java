package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class Message {

	private Integer messageId;
	private User from;
	private Integer date;
	private UserOrGroupChat chat;
	private User forwardFrom;
	private Integer forwardDate;
	private Message replyToMessage;
	private String text;
	private Audio audio;
	private Document document;
	private PhotoSize[] photo;
	private Sticker sticker;
	private Video video;
	private Contact contact;
	private Location location;
	private User newChatParticipant;
	private User leftChatParticipant;
	private String newChatTitle;
	private PhotoSize[] newChatPhoto;
	private Boolean deleteChatPhoto;
	private Boolean groupChatCreated;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(Integer messageId, User from, Integer date, UserOrGroupChat chat, User forwardFrom,
			Integer forwardDate, Message replyToMessage, String text, Audio audio, Document document, PhotoSize[] photo,
			Sticker sticker, Video video, Contact contact, Location location, User newChatParticipant,
			User leftChatParticipant, String newChatTitle, PhotoSize[] newChatPhoto, Boolean deleteChatPhoto,
			Boolean groupChatCreated) {
		super();
		this.messageId = messageId;
		this.from = from;
		this.date = date;
		this.chat = chat;
		this.forwardFrom = forwardFrom;
		this.forwardDate = forwardDate;
		this.replyToMessage = replyToMessage;
		this.text = text;
		this.audio = audio;
		this.document = document;
		this.photo = photo;
		this.sticker = sticker;
		this.video = video;
		this.contact = contact;
		this.location = location;
		this.newChatParticipant = newChatParticipant;
		this.leftChatParticipant = leftChatParticipant;
		this.newChatTitle = newChatTitle;
		this.newChatPhoto = newChatPhoto;
		this.deleteChatPhoto = deleteChatPhoto;
		this.groupChatCreated = groupChatCreated;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	public UserOrGroupChat getChat() {
		return chat;
	}
	public void setChat(UserOrGroupChat chat) {
		this.chat = chat;
	}
	public User getForwardFrom() {
		return forwardFrom;
	}
	public void setForwardFrom(User forwardFrom) {
		this.forwardFrom = forwardFrom;
	}
	public Integer getForwardDate() {
		return forwardDate;
	}
	public void setForwardDate(Integer forwardDate) {
		this.forwardDate = forwardDate;
	}
	public Message getReplyToMessage() {
		return replyToMessage;
	}
	public void setReplyToMessage(Message replyToMessage) {
		this.replyToMessage = replyToMessage;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Audio getAudio() {
		return audio;
	}
	public void setAudio(Audio audio) {
		this.audio = audio;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public PhotoSize[] getPhoto() {
		return photo;
	}
	public void setPhoto(PhotoSize[] photo) {
		this.photo = photo;
	}
	public Sticker getSticker() {
		return sticker;
	}
	public void setSticker(Sticker sticker) {
		this.sticker = sticker;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public User getNewChatParticipant() {
		return newChatParticipant;
	}
	public void setNewChatParticipant(User newChatParticipant) {
		this.newChatParticipant = newChatParticipant;
	}
	public User getLeftChatParticipant() {
		return leftChatParticipant;
	}
	public void setLeftChatParticipant(User leftChatParticipant) {
		this.leftChatParticipant = leftChatParticipant;
	}
	public String getNewChatTitle() {
		return newChatTitle;
	}
	public void setNewChatTitle(String newChatTitle) {
		this.newChatTitle = newChatTitle;
	}
	public PhotoSize[] getNewChatPhoto() {
		return newChatPhoto;
	}
	public void setNewChatPhoto(PhotoSize[] newChatPhoto) {
		this.newChatPhoto = newChatPhoto;
	}
	public Boolean getDeleteChatPhoto() {
		return deleteChatPhoto;
	}
	public void setDeleteChatPhoto(Boolean deleteChatPhoto) {
		this.deleteChatPhoto = deleteChatPhoto;
	}
	public Boolean getGroupChatCreated() {
		return groupChatCreated;
	}
	public void setGroupChatCreated(Boolean groupChatCreated) {
		this.groupChatCreated = groupChatCreated;
	}
}

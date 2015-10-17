package com.pengrad.telegrambot.model;

import java.util.Arrays;

/**
 * stas 8/4/15.
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((audio == null) ? 0 : audio.hashCode());
		result = prime * result + ((chat == null) ? 0 : chat.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((deleteChatPhoto == null) ? 0 : deleteChatPhoto.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((forwardDate == null) ? 0 : forwardDate.hashCode());
		result = prime * result + ((forwardFrom == null) ? 0 : forwardFrom.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((groupChatCreated == null) ? 0 : groupChatCreated.hashCode());
		result = prime * result + ((leftChatParticipant == null) ? 0 : leftChatParticipant.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((messageId == null) ? 0 : messageId.hashCode());
		result = prime * result + ((newChatParticipant == null) ? 0 : newChatParticipant.hashCode());
		result = prime * result + Arrays.hashCode(newChatPhoto);
		result = prime * result + ((newChatTitle == null) ? 0 : newChatTitle.hashCode());
		result = prime * result + Arrays.hashCode(photo);
		result = prime * result + ((replyToMessage == null) ? 0 : replyToMessage.hashCode());
		result = prime * result + ((sticker == null) ? 0 : sticker.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
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
		Message other = (Message) obj;
		if (audio == null) {
			if (other.audio != null)
				return false;
		} else if (!audio.equals(other.audio))
			return false;
		if (chat == null) {
			if (other.chat != null)
				return false;
		} else if (!chat.equals(other.chat))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (deleteChatPhoto == null) {
			if (other.deleteChatPhoto != null)
				return false;
		} else if (!deleteChatPhoto.equals(other.deleteChatPhoto))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (forwardDate == null) {
			if (other.forwardDate != null)
				return false;
		} else if (!forwardDate.equals(other.forwardDate))
			return false;
		if (forwardFrom == null) {
			if (other.forwardFrom != null)
				return false;
		} else if (!forwardFrom.equals(other.forwardFrom))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (groupChatCreated == null) {
			if (other.groupChatCreated != null)
				return false;
		} else if (!groupChatCreated.equals(other.groupChatCreated))
			return false;
		if (leftChatParticipant == null) {
			if (other.leftChatParticipant != null)
				return false;
		} else if (!leftChatParticipant.equals(other.leftChatParticipant))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		if (newChatParticipant == null) {
			if (other.newChatParticipant != null)
				return false;
		} else if (!newChatParticipant.equals(other.newChatParticipant))
			return false;
		if (!Arrays.equals(newChatPhoto, other.newChatPhoto))
			return false;
		if (newChatTitle == null) {
			if (other.newChatTitle != null)
				return false;
		} else if (!newChatTitle.equals(other.newChatTitle))
			return false;
		if (!Arrays.equals(photo, other.photo))
			return false;
		if (replyToMessage == null) {
			if (other.replyToMessage != null)
				return false;
		} else if (!replyToMessage.equals(other.replyToMessage))
			return false;
		if (sticker == null) {
			if (other.sticker != null)
				return false;
		} else if (!sticker.equals(other.sticker))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", from=" + from + ", date=" + date + ", chat=" + chat
				+ ", forwardFrom=" + forwardFrom + ", forwardDate=" + forwardDate + ", replyToMessage=" + replyToMessage
				+ ", text=" + text + ", audio=" + audio + ", document=" + document + ", photo=" + Arrays.toString(photo)
				+ ", sticker=" + sticker + ", video=" + video + ", contact=" + contact + ", location=" + location
				+ ", newChatParticipant=" + newChatParticipant + ", leftChatParticipant=" + leftChatParticipant
				+ ", newChatTitle=" + newChatTitle + ", newChatPhoto=" + Arrays.toString(newChatPhoto)
				+ ", deleteChatPhoto=" + deleteChatPhoto + ", groupChatCreated=" + groupChatCreated + "]";
	}
}

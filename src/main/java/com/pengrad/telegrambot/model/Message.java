package com.pengrad.telegrambot.model;

import java.util.Arrays;

/**
 * stas 8/4/15.
 */
public class Message {

	private Integer message_id;
	private User from;
	private Integer date;
	private UserOrGroupChat chat;
	private User forward_from;
	private Integer forward_date;
	private Message reply_to_message;
	private String text;
	private Audio audio;
	private Document document;
	private PhotoSize[] photo;
	private Sticker sticker;
	private Video video;
	private Contact contact;
	private Location location;
	private User new_chat_participant;
	private User left_chat_participant;
	private String new_chat_title;
	private PhotoSize[] new_chat_photo;
	private Boolean delete_chat_photo;
	private Boolean group_chat_created;

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
		this.message_id = messageId;
		this.from = from;
		this.date = date;
		this.chat = chat;
		this.forward_from = forwardFrom;
		this.forward_date = forwardDate;
		this.reply_to_message = replyToMessage;
		this.text = text;
		this.audio = audio;
		this.document = document;
		this.photo = photo;
		this.sticker = sticker;
		this.video = video;
		this.contact = contact;
		this.location = location;
		this.new_chat_participant = newChatParticipant;
		this.left_chat_participant = leftChatParticipant;
		this.new_chat_title = newChatTitle;
		this.new_chat_photo = newChatPhoto;
		this.delete_chat_photo = deleteChatPhoto;
		this.group_chat_created = groupChatCreated;
	}

	public Integer getMessageId() {
		return message_id;
	}

	public User getFrom() {
		return from;
	}

	public Integer getDate() {
		return date;
	}

	public UserOrGroupChat getChat() {
		return chat;
	}

	public User getForwardFrom() {
		return forward_from;
	}

	public Integer getForwardDate() {
		return forward_date;
	}

	public Message getReplyToMessage() {
		return reply_to_message;
	}

	public String getText() {
		return text;
	}

	public Audio getAudio() {
		return audio;
	}

	public Document getDocument() {
		return document;
	}

	public PhotoSize[] getPhoto() {
		return photo;
	}

	public Sticker getSticker() {
		return sticker;
	}

	public Video getVideo() {
		return video;
	}

	public Contact getContact() {
		return contact;
	}

	public Location getLocation() {
		return location;
	}

	public User getNewChatParticipant() {
		return new_chat_participant;
	}

	public User getLeftChatParticipant() {
		return left_chat_participant;
	}

	public String getNewChatTitle() {
		return new_chat_title;
	}

	public PhotoSize[] getNewChatPhoto() {
		return new_chat_photo;
	}

	public Boolean getDeleteChatPhoto() {
		return delete_chat_photo;
	}

	public Boolean getGroupChatCreated() {
		return group_chat_created;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((audio == null) ? 0 : audio.hashCode());
		result = prime * result + ((chat == null) ? 0 : chat.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((delete_chat_photo == null) ? 0 : delete_chat_photo.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((forward_date == null) ? 0 : forward_date.hashCode());
		result = prime * result + ((forward_from == null) ? 0 : forward_from.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((group_chat_created == null) ? 0 : group_chat_created.hashCode());
		result = prime * result + ((left_chat_participant == null) ? 0 : left_chat_participant.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((message_id == null) ? 0 : message_id.hashCode());
		result = prime * result + ((new_chat_participant == null) ? 0 : new_chat_participant.hashCode());
		result = prime * result + Arrays.hashCode(new_chat_photo);
		result = prime * result + ((new_chat_title == null) ? 0 : new_chat_title.hashCode());
		result = prime * result + Arrays.hashCode(photo);
		result = prime * result + ((reply_to_message == null) ? 0 : reply_to_message.hashCode());
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
		if (delete_chat_photo == null) {
			if (other.delete_chat_photo != null)
				return false;
		} else if (!delete_chat_photo.equals(other.delete_chat_photo))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (forward_date == null) {
			if (other.forward_date != null)
				return false;
		} else if (!forward_date.equals(other.forward_date))
			return false;
		if (forward_from == null) {
			if (other.forward_from != null)
				return false;
		} else if (!forward_from.equals(other.forward_from))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (group_chat_created == null) {
			if (other.group_chat_created != null)
				return false;
		} else if (!group_chat_created.equals(other.group_chat_created))
			return false;
		if (left_chat_participant == null) {
			if (other.left_chat_participant != null)
				return false;
		} else if (!left_chat_participant.equals(other.left_chat_participant))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (message_id == null) {
			if (other.message_id != null)
				return false;
		} else if (!message_id.equals(other.message_id))
			return false;
		if (new_chat_participant == null) {
			if (other.new_chat_participant != null)
				return false;
		} else if (!new_chat_participant.equals(other.new_chat_participant))
			return false;
		if (!Arrays.equals(new_chat_photo, other.new_chat_photo))
			return false;
		if (new_chat_title == null) {
			if (other.new_chat_title != null)
				return false;
		} else if (!new_chat_title.equals(other.new_chat_title))
			return false;
		if (!Arrays.equals(photo, other.photo))
			return false;
		if (reply_to_message == null) {
			if (other.reply_to_message != null)
				return false;
		} else if (!reply_to_message.equals(other.reply_to_message))
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
		return "Message [messageId=" + message_id + ", from=" + from + ", date=" + date + ", chat=" + chat
				+ ", forwardFrom=" + forward_from + ", forwardDate=" + forward_date + ", replyToMessage="
				+ reply_to_message + ", text=" + text + ", audio=" + audio + ", document=" + document + ", photo="
				+ Arrays.toString(photo) + ", sticker=" + sticker + ", video=" + video + ", contact=" + contact
				+ ", location=" + location + ", newChatParticipant=" + new_chat_participant + ", leftChatParticipant="
				+ left_chat_participant + ", newChatTitle=" + new_chat_title + ", newChatPhoto="
				+ Arrays.toString(new_chat_photo) + ", deleteChatPhoto=" + delete_chat_photo + ", groupChatCreated="
				+ group_chat_created + "]";
	}
}

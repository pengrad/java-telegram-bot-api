package com.pengrad.telegrambot.model.request;

public class InlineKeyboardButton {

	private String text;
	private String url;
	private String callback_data;
	private String switch_inline_query;

	public InlineKeyboardButton( String text, String externalUrl, String callbackData, String switchInlineQuery ) {

		this.text = text;
		this.url = externalUrl;
		this.callback_data = callbackData;
		this.switch_inline_query = switchInlineQuery;
	}

	public String getText() {

		return text;
	}

	public void setText(
			String text ) {

		this.text = text;
	}

	public String getUrl() {

		return url;
	}

	public void setUrl(
			String url ) {

		this.url = url;
	}

	public String getCallback_data() {

		return callback_data;
	}

	public void setCallback_data(
			String callback_data ) {

		this.callback_data = callback_data;
	}

	public String getSwitch_inline_query() {

		return switch_inline_query;
	}

	public void setSwitch_inline_query(
			String switch_inline_query ) {

		this.switch_inline_query = switch_inline_query;
	}

}

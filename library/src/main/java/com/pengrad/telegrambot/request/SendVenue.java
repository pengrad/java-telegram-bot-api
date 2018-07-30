package com.pengrad.telegrambot.request;

/**
 * stas
 * 5/1/16.
 */
public class SendVenue extends AbstractSendRequest<SendVenue> {

    public SendVenue(Object chatId, float latitude, float longitude, String title, String address) {
        super(chatId);
        add("latitude", latitude);
        add("longitude", longitude);
        add("title", title);
        add("address", address);
    }

    public SendVenue foursquareId(String foursquareId) {
        return add("foursquare_id", foursquareId);
    }

    public SendVenue foursquareType(String foursquareType) {
        return add("foursquare_type", foursquareType);
    }
}

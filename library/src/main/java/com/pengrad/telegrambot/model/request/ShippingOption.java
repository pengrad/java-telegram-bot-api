package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 24 May 2017
 */
public class ShippingOption implements Serializable {
    private final static long serialVersionUID = 0L;

    private String id, title;
    private LabeledPrice[] prices;

    public ShippingOption(String id, String title, LabeledPrice... prices) {
        this.id = id;
        this.title = title;
        this.prices = prices;
    }
}

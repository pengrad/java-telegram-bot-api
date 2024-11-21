package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Gifts implements Serializable {
    private final static long serialVersionUID = 0L;

    private Gift[] gifts;

    public Gift[] gifts() {
        return gifts;
    }

    @Override
    public String toString() {
        return "GetAvailableGiftsResponse{" +
                "gifts=" + Arrays.toString(gifts) +
                '}';
    }
}

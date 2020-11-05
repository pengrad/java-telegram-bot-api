package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 06 November 2020
 */
public class ProximityAlertTriggered implements Serializable {
    private final static long serialVersionUID = 0L;

    private User traveler;
    private User watcher;
    private Integer distance;

    public User traveler() {
        return traveler;
    }

    public User watcher() {
        return watcher;
    }

    public Integer distance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProximityAlertTriggered that = (ProximityAlertTriggered) o;
        return Objects.equals(traveler, that.traveler) &&
                Objects.equals(watcher, that.watcher) &&
                Objects.equals(distance, that.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traveler, watcher, distance);
    }

    @Override
    public String toString() {
        return "ProximityAlertTriggered{" +
                "traveler=" + traveler +
                ", watcher=" + watcher +
                ", distance=" + distance +
                '}';
    }
}

package com.dpaula.compras.event;

import java.time.LocalDateTime;

public class DataEvent<K, T> {

    private final K key;
    private final T data;
    private final EventType eventType;
    private final LocalDateTime eventCreatedAt;

    public DataEvent() {
        key = null;
        data = null;
        eventType = null;
        eventCreatedAt = null;
    }

    public DataEvent(final EventType eventType, final K key, final T data) {
        this.key = key;
        this.data = data;
        this.eventType = eventType;
        eventCreatedAt = LocalDateTime.now();
    }

    public K getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public EventType getEventType() {
        return eventType;
    }

    public LocalDateTime getEventCreatedAt() {
        return eventCreatedAt;
    }
}

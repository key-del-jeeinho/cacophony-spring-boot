package com.velocia.cacophony.domain.event.enum_type;

import com.velocia.cacophony.domain.event.events.JoinEvent;
import com.velocia.cacophony.domain.event.events.ChatEvent;
import com.velocia.cacophony.domain.event.events.Event;
import com.velocia.cacophony.domain.event.exception.EventTypeNotFoundException;

import java.util.Arrays;
import java.util.Optional;

public enum EventType {
    CHAT_EVENT(ChatEvent.class), JOIN_EVENT(JoinEvent.class);

    private final Class<? extends Event> clazz;

    EventType(Class<? extends Event> clazz) {
        this.clazz = clazz;
    }

    public static EventType of(Class<? extends Event> clazz) {
        Optional<EventType> result = Arrays.stream(values()).filter(event -> event.getClazz().equals(clazz))
                .findFirst();
        if(result.isEmpty()) throw new EventTypeNotFoundException(clazz);
        return result.get();
    }

    public Class<? extends Event> getClazz() {
        return clazz;
    }
}

package io.github.key_del_jeeinho.cacophony_lib.domain.event.enum_type;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.JoinEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.Event;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.exception.EventTypeNotFoundException;

import java.util.Arrays;
import java.util.Optional;

/**
 * Event 의 형식을 명시하는 Enum 입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
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

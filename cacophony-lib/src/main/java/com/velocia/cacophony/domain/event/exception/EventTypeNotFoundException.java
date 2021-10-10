package com.velocia.cacophony.domain.event.exception;

import com.velocia.cacophony.domain.event.events.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventTypeNotFoundException extends RuntimeException {
    @Getter
    private final Class<? extends Event> clazz;
}

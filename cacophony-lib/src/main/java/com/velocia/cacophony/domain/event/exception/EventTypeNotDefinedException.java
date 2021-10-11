package com.velocia.cacophony.domain.event.exception;

import com.velocia.cacophony.domain.event.enum_type.EventType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EventTypeNotDefinedException extends RuntimeException {
    private final EventType target;
}

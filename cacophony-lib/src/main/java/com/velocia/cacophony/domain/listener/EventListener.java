package com.velocia.cacophony.domain.listener;

import com.velocia.cacophony.domain.event.events.Event;

@FunctionalInterface
public interface EventListener<T extends Event> {
    void call(T event);
}

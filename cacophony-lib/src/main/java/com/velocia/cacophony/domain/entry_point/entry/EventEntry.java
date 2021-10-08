package com.velocia.cacophony.domain.entry_point.entry;

import com.velocia.cacophony.domain.event.Event;

public class EventEntry {
    public static Class<? extends Event> onChat() {
        return Event.class;
    }

}

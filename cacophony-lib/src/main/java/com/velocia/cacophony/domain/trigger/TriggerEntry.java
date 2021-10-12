package com.velocia.cacophony.domain.trigger;

import com.velocia.cacophony.domain.entry.annotation.EntryPoint;
import com.velocia.cacophony.domain.event.events.ChatEvent;

public class TriggerEntry {
    @EntryPoint
    public static TriggerGroup onChat() {
        return new TriggerGroup(ChatEvent.class);
    }
}

package com.velocia.cacophony.domain.trigger;

import com.velocia.cacophony.domain.entry.annotation.EntryPoint;
import com.velocia.cacophony.domain.event.events.ChatEvent;
import com.velocia.cacophony.domain.event.events.JoinEvent;

/**
 * Trigger 에 대한 진입지점입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class TriggerEntry {
    @EntryPoint
    public static TriggerGroup onChat() {
        return new TriggerGroup(ChatEvent.class);
    }

    @EntryPoint
    public static TriggerGroup onJoin() {
        return new TriggerGroup(JoinEvent.class);
    }
}

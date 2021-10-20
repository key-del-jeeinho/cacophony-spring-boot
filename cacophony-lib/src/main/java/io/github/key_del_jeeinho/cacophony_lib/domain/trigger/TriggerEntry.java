package io.github.key_del_jeeinho.cacophony_lib.domain.trigger;

import io.github.key_del_jeeinho.cacophony_lib.domain.entry.annotation.EntryPoint;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.JoinEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.QuitEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.ReactEvent;

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

    @EntryPoint
    public static TriggerGroup onQuit() {
        return new TriggerGroup(QuitEvent.class);
    }

    @EntryPoint
    public static TriggerGroup onReact() {
        return new TriggerGroup(ReactEvent.class);
    }
}

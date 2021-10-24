package io.github.key_del_jeeinho.cacophony_lib.domain.entry;

import io.github.key_del_jeeinho.cacophony_lib.global.annotation.EntryPoint;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.JoinEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.QuitEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.PrivateChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ServerChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.PrivateReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ServerReactEvent;

/**
 * Trigger 에 대한 진입지점입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class TriggerEntry {
    @EntryPoint
    public static EntryGroup onChat() {
        return new EntryGroup(ChatEvent.class);
    }

    @EntryPoint
    public static EntryGroup onDM() {
        return new EntryGroup(PrivateChatEvent.class);
    }

    @EntryPoint
    public static EntryGroup onChatAtServer() {
        return new EntryGroup(ServerChatEvent.class);
    }

    @EntryPoint
    public static EntryGroup onJoin() {
        return new EntryGroup(JoinEvent.class);
    }

    @EntryPoint
    public static EntryGroup onQuit() {
        return new EntryGroup(QuitEvent.class);
    }

    @EntryPoint
    public static EntryGroup onReact() {
        return new EntryGroup(ReactEvent.class);
    }

    @EntryPoint
    public static EntryGroup onReactAtPrivate() {
        return new EntryGroup(PrivateReactEvent.class);
    }

    @EntryPoint
    public static EntryGroup onReactAtServer() {
        return new EntryGroup(ServerReactEvent.class);
    }
}

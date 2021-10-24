package io.github.key_del_jeeinho.cacophony_lib.domain.entry;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.*;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.PrivateChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ServerChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.PrivateReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ServerReactEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Flow 가 실행될 Trigger 를 모아놓은 Group 입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class EntryGroup {
    @Getter
    private final List<Class<? extends Event>> classes;

    private EntryGroup() {
        classes = new ArrayList<>();
    }
    public EntryGroup(Class<? extends Event> clazz) {
        this();
        classes.add(clazz);
    }
    public EntryGroup(List<Class<? extends Event>> classes) {
        this.classes = classes;
    }

    public TriggerGroupBuilder and() {
        return new TriggerGroupBuilder(this);
    }

    public static class TriggerGroupBuilder {
        List<Class<? extends Event>> list;
        public TriggerGroupBuilder(EntryGroup origin) {
           list = new ArrayList<>(origin.classes);
        }

        public EntryGroup onChat() {
            list.add(ChatEvent.class);
            return new EntryGroup(list);
        }

        public EntryGroup onDM() {
            list.add(PrivateChatEvent.class);
            return new EntryGroup(list);
        }

        public EntryGroup onChatAtServer() {
            list.add(ServerChatEvent.class);
            return new EntryGroup(list);
        }

        public EntryGroup onJoin() {
            list.add(JoinEvent.class);
            return new EntryGroup(list);
        }

        public EntryGroup onQuit() {
            list.add(QuitEvent.class);
            return new EntryGroup(list);
        }

        public EntryGroup onReact() {
            list.add(ReactEvent.class);
            return new EntryGroup(list);
        }

        public EntryGroup onReactAtPrivate() {
            list.add(PrivateReactEvent.class);
            return new EntryGroup(list);
        }

        public EntryGroup onReactAtServer() {
            list.add(ServerReactEvent.class);
            return new EntryGroup(list);
        }
    }
}

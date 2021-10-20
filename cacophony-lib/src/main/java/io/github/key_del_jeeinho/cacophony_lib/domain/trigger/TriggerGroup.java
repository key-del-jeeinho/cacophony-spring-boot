package io.github.key_del_jeeinho.cacophony_lib.domain.trigger;

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
public class TriggerGroup {
    @Getter
    private final List<Class<? extends Event>> classes;

    private TriggerGroup() {
        classes = new ArrayList<>();
    }
    public TriggerGroup(Class<? extends Event> clazz) {
        this();
        classes.add(clazz);
    }
    public TriggerGroup(List<Class<? extends Event>> classes) {
        this.classes = classes;
    }

    public TriggerGroupBuilder and() {
        return new TriggerGroupBuilder(this);
    }

    public static class TriggerGroupBuilder {
        List<Class<? extends Event>> list;
        public TriggerGroupBuilder(TriggerGroup origin) {
           list = new ArrayList<>(origin.classes);
        }

        public TriggerGroup onChat() {
            list.add(ChatEvent.class);
            return new TriggerGroup(list);
        }

        public TriggerGroup onDM() {
            list.add(PrivateChatEvent.class);
            return new TriggerGroup(list);
        }

        public TriggerGroup onChatAtServer() {
            list.add(ServerChatEvent.class);
            return new TriggerGroup(list);
        }

        public TriggerGroup onJoin() {
            list.add(JoinEvent.class);
            return new TriggerGroup(list);
        }

        public TriggerGroup onQuit() {
            list.add(QuitEvent.class);
            return new TriggerGroup(list);
        }

        public TriggerGroup onReact() {
            list.add(ReactEvent.class);
            return new TriggerGroup(list);
        }

        public TriggerGroup onReactAtPrivate() {
            list.add(PrivateReactEvent.class);
            return new TriggerGroup(list);
        }

        public TriggerGroup onReactAtServer() {
            list.add(ServerReactEvent.class);
            return new TriggerGroup(list);
        }
    }
}

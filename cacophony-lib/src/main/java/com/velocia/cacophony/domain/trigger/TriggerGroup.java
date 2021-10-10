package com.velocia.cacophony.domain.trigger;

import com.velocia.cacophony.domain.event.events.JoinEvent;
import com.velocia.cacophony.domain.event.events.ChatEvent;
import com.velocia.cacophony.domain.event.events.Event;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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

        public TriggerGroup onJoin() {
            list.add(JoinEvent.class);
            return new TriggerGroup(list);
        }
    }
}

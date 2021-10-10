package com.velocia.cacophony.domain.event;

import com.velocia.cacophony.domain.event.events.Event;
import com.velocia.cacophony.domain.event.enum_type.EventType;
import com.velocia.cacophony.domain.listener.EventListener;
import net.dv8tion.jda.api.JDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ListenerCaller {
    @Autowired
    private JDA jda;
    Map<Class, List<EventListener>> chatEventListeners;

    public ListenerCaller() {
        this.chatEventListeners = new HashMap<>();
    }

    public void callEvent(Event event) {
        Class<? extends Event> clazz = event.getClass();
        switch (EventType.of(clazz)) {
            case CHAT_EVENT:
                chatEventListeners.forEach((key, listeners) ->
                        listeners.forEach(listener -> listener.call(event))
                );
        }
    }

    public <T extends Event> void addListener(Class<T> clazz, EventListener listener) {
        switch (EventType.of(clazz)) {
            case CHAT_EVENT:
                if(chatEventListeners.containsKey(clazz))
                    chatEventListeners.get(clazz).add(listener);
                else chatEventListeners.put(clazz, new ArrayList<>(List.of(listener)));
        }
        System.out.println(clazz.getSimpleName() + "에 대한 listener 를 추가하였습니다!\n listener : " + listener);
    }
}

package com.velocia.cacophony.domain.event;

import com.velocia.cacophony.domain.event.events.Event;
import com.velocia.cacophony.domain.listener.EventListener;
import net.dv8tion.jda.api.JDA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListenerCaller {
    private final JDA jda;
    Map<Class<? extends Event>, List<EventListener>> listeners;

    public ListenerCaller(JDA jda) {
        this.jda = jda;
        this.listeners = new HashMap<>();
    }

    public void callEvent(Event event) {
        Class<? extends Event> clazz = event.getClass();
        if(listeners.containsKey(clazz))
            listeners.get(clazz).forEach(listener -> listener.call(event));
    }

    public <T extends Event> void addListener(Class<T> clazz, EventListener listener) {
        if(listeners.containsKey(clazz))
            listeners.get(clazz).add(listener);
        else listeners.put(clazz, new ArrayList<>(List.of(listener)));
        System.out.println(clazz.getSimpleName() + "에 대한 listener 를 추가하였습니다!\n listener : " + listener);
    }
}

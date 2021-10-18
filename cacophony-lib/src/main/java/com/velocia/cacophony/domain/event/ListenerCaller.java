package com.velocia.cacophony.domain.event;

import com.velocia.cacophony.domain.event.events.Event;
import com.velocia.cacophony.domain.listener.EventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repeat 된 Event 를 Calling 받아 Listener 들을 호출하는 클래스입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@Slf4j
public class ListenerCaller {
    Map<Class<? extends Event>, List<EventListener>> listeners;

    public ListenerCaller() {
        this.listeners = new HashMap<>();
    }

    public void callEvent(Event event) {
        Class<? extends Event> clazz = event.getClass();
        if(listeners.containsKey(clazz)) {
            try {
                listeners.get(clazz).forEach(listener -> listener.call(clazz.cast(event)));
            } catch (ClassCastException e) {
                log.warn("Flow 의 Trigger 와 Action 에서 취급하는 Event 가 다릅니다!");
                log.warn("발생한 이벤트(Trigger) : " + clazz.getSimpleName());
                log.error("오류로 인해 Flow 의 특정 Component 가 Skip 되었습니다!");
            }
        }
    }

    public <T extends Event> void addListener(Class<T> clazz, EventListener listener) {
        if(listeners.containsKey(clazz))
            listeners.get(clazz).add(listener);
        else listeners.put(clazz, new ArrayList<>(List.of(listener)));
        System.out.println(clazz.getSimpleName() + "에 대한 listener 를 추가하였습니다!\n listener : " + listener);
    }
}

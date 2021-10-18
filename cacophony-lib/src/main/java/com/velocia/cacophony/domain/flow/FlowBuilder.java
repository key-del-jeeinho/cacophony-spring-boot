package com.velocia.cacophony.domain.flow;

import com.velocia.cacophony.domain.event.ListenerCaller;
import com.velocia.cacophony.domain.event.events.Event;
import com.velocia.cacophony.domain.listener.EventListener;
import com.velocia.cacophony.domain.trigger.TriggerGroup;

import java.util.List;
import java.util.function.Consumer;

/**
 * Cacophony 의 핵심 도메인인 Flow 를 생성하는 Builder 입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class FlowBuilder<T extends Event> {
    private final ListenerCaller listenerCaller;
    TriggerGroup triggers;
    EventListener<T> doWhat;

    public FlowBuilder(ListenerCaller listenerCaller) {
        this.listenerCaller = listenerCaller;
    }

    public FlowBuilder triggers(TriggerGroup triggers) {
        this.triggers = triggers;
        return this;
    }

    public FlowBuilder doSomething(EventListener<T> doWhat) {
        this.doWhat = doWhat;
        return this;
    }

    public void complete() {
        List<Class<? extends Event>> classes = triggers.getClasses();
        classes.forEach(clazz -> listenerCaller.addListener(clazz, doWhat));
    }
}

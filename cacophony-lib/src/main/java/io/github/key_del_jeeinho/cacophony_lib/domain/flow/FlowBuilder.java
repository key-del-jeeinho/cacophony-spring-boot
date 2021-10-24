package io.github.key_del_jeeinho.cacophony_lib.domain.flow;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.Event;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.listeners.EventListener;
import io.github.key_del_jeeinho.cacophony_lib.domain.entry.EntryGroup;

import java.util.List;

/**
 * Cacophony 의 핵심 도메인인 Flow 를 생성하는 Builder 입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class FlowBuilder<T extends Event> {
    private final ListenerCaller listenerCaller;
    EntryGroup triggers;
    EventListener<T> doWhat;

    public FlowBuilder(ListenerCaller listenerCaller) {
        this.listenerCaller = listenerCaller;
    }

    public FlowBuilder when(EntryGroup triggers) {
        this.triggers = triggers;
        return this;
    }

    public FlowBuilder doAction(EventListener<T> doWhat) {
        this.doWhat = doWhat;
        return this;
    }

    public void complete() {
        List<Class<? extends Event>> classes = triggers.getClasses();
        classes.forEach(clazz -> listenerCaller.addListener(clazz, doWhat));
    }
}

package com.velocia.cacophony.domain.flow;

import com.velocia.cacophony.domain.event.ListenerCaller;
import com.velocia.cacophony.domain.event.events.Event;
import com.velocia.cacophony.domain.trigger.TriggerGroup;

import java.util.List;
import java.util.function.Consumer;

public class FlowBuilder {
    private final ListenerCaller listenerCaller;
    TriggerGroup triggers;
    Consumer<Event> doWhat;

    public FlowBuilder(ListenerCaller listenerCaller) {
        this.listenerCaller = listenerCaller;
    }

    public FlowBuilder triggers(TriggerGroup triggers) {
        this.triggers = triggers;
        return this;
    }

    public FlowBuilder doSomething(Consumer<Event> doWhat) {
        this.doWhat = doWhat;
        return this;
    }

    public void complete() {
        List<Class<? extends Event>> classes = triggers.getClasses();
        classes.forEach(clazz -> listenerCaller.addListener(clazz, event -> doWhat.accept(event)));
    }
}

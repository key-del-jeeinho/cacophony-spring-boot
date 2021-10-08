package com.velocia.cacophony.domain.entry_point.entry;

import com.velocia.cacophony.domain.entry_point.annotation.EntryPoint;
import com.velocia.cacophony.domain.event.Event;
import com.velocia.cacophony.domain.flow.builder.FlowBuilder;
import com.velocia.cacophony.domain.flow.builder.SimpleFlowBuilder;

import java.util.function.Consumer;

public class DoEntry {
    @EntryPoint
    public static FlowBuilder doSomething(Consumer<Event> doWhat) {
        return new SimpleFlowBuilder().doSomething(doWhat);
    }
}

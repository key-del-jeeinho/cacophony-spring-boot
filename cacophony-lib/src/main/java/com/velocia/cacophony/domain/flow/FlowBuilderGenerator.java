package com.velocia.cacophony.domain.flow;

import com.velocia.cacophony.domain.event.ListenerCaller;

public class FlowBuilderGenerator {
    private static ListenerCaller listenerCaller;

    public FlowBuilderGenerator(ListenerCaller listenerCaller) {
        if(FlowBuilderGenerator.listenerCaller == null)
            FlowBuilderGenerator.listenerCaller = listenerCaller;
    }

    public static FlowBuilder generateDefault() {
        return new FlowBuilder(listenerCaller);
    }
}

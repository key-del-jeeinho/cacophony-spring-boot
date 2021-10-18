package com.velocia.cacophony.domain.flow;

import com.velocia.cacophony.domain.event.ListenerCaller;

public class FlowBuilderGenerator {
    private static ListenerCaller listenerCaller;

    public static FlowBuilder generateDefault() {
        return new FlowBuilder(listenerCaller);
    }

    public static FlowBuilderGenerator init(ListenerCaller listenerCaller) {
        FlowBuilderGenerator.listenerCaller = listenerCaller;
        return new FlowBuilderGenerator();
    }
}

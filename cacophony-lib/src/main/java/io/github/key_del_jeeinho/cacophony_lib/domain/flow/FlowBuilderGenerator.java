package io.github.key_del_jeeinho.cacophony_lib.domain.flow;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;

/**
 * 표준 FlowBuilder 를 생성하는 Generator 입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class FlowBuilderGenerator {
    private static ListenerCaller listenerCaller;

    public static FlowBuilder generateDefault() {
        return new FlowBuilder(listenerCaller);
    }

    public static void init(ListenerCaller listenerCaller) {
        FlowBuilderGenerator.listenerCaller = listenerCaller;
    }
}

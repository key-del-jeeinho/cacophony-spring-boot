package io.github.key_del_jeeinho.cacophony_lib.domain.flow;

import io.github.key_del_jeeinho.cacophony_lib.domain.entry.annotation.EntryPoint;
import io.github.key_del_jeeinho.cacophony_lib.domain.trigger.EntryGroup;

/**
 * Flow 에 대한 진입지점입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class FlowEntry {
    @EntryPoint
    public static FlowBuilder when(EntryGroup triggers) {
        return FlowBuilderGenerator.generateDefault().when(triggers);
    }
}

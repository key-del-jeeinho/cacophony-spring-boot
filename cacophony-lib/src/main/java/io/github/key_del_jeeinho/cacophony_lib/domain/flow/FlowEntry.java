package io.github.key_del_jeeinho.cacophony_lib.domain.flow;

import io.github.key_del_jeeinho.cacophony_lib.global.annotation.EntryPoint;
import io.github.key_del_jeeinho.cacophony_lib.domain.entry.EntryGroup;

/**
 * Flow 에 대한 진입지점입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class FlowEntry {
    @EntryPoint
    public static Flow when(EntryGroup triggers) {
        return FlowGenerator.generateDefault().when(triggers);
    }
}

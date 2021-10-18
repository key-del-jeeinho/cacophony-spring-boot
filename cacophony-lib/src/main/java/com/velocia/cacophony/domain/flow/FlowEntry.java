package com.velocia.cacophony.domain.flow;

import com.velocia.cacophony.domain.entry.annotation.EntryPoint;
import com.velocia.cacophony.domain.trigger.TriggerGroup;

/**
 * Flow 에 대한 진입지점입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class FlowEntry {
    @EntryPoint
    public static FlowBuilder when(TriggerGroup triggers) {
        return FlowBuilderGenerator.generateDefault().triggers(triggers);
    }
}

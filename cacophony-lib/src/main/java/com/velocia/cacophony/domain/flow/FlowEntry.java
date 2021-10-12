package com.velocia.cacophony.domain.flow;

import com.velocia.cacophony.domain.entry.annotation.EntryPoint;
import com.velocia.cacophony.domain.trigger.TriggerGroup;

public class FlowEntry {
    @EntryPoint
    public static FlowBuilder when(TriggerGroup triggers) {
        return FlowBuilderGenerator.generateDefault().triggers(triggers);
    }
}

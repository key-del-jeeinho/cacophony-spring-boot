package com.velocia.cacophony.domain.flow;

import com.velocia.cacophony.domain.trigger.TriggerGroup;

public class FlowEntry {
    public static FlowBuilder when(TriggerGroup triggers) {
        return new FlowBuilder().triggers(triggers);
    }
}

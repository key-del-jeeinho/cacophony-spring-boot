package com.velocia.cacophony.domain.entry_point.entry;

import com.velocia.cacophony.domain.condition.TimeConditionGroup;
import com.velocia.cacophony.domain.condition.enum_type.RelativeTime;
import com.velocia.cacophony.domain.entry_point.annotation.EntryPoint;
import com.velocia.cacophony.domain.event.Event;


public class TimeConditionEntry {
    @EntryPoint
    public static TimeConditionGroup before(Class<? extends Event> event) {
        return new TimeConditionGroup(event, RelativeTime.BEFORE);
    }
}

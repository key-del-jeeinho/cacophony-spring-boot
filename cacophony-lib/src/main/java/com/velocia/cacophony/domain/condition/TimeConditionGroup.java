package com.velocia.cacophony.domain.condition;

import com.velocia.cacophony.domain.condition.enum_type.RelativeTime;
import com.velocia.cacophony.domain.event.Event;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

public class TimeConditionGroup {
    HashMap<Class<? extends Event>, RelativeTime> timeConditions;

    public TimeConditionGroup() {
        this.timeConditions = new HashMap<>();
    }
    public TimeConditionGroup(Class<? extends Event> event, RelativeTime relativeTime) {
        this();
        addCondition(event, relativeTime);
    }

    public TimeConditionGroupBuilder and() {
        return this.new TimeConditionGroupBuilder();
    }

    private void addCondition(Class<? extends Event> event, RelativeTime relativeTime) {
        if(timeConditions.containsKey(event))
            timeConditions.put(event,
                    timeConditions.get(event).add(relativeTime));
        timeConditions.put(event, relativeTime);
    }

    private TimeConditionGroup get() {
        return this;
    }

    @RequiredArgsConstructor
    public class TimeConditionGroupBuilder {
        public TimeConditionGroup after(Class<? extends Event> event) {
            addCondition(event, RelativeTime.AFTER);
            return get();
        }
    }
}

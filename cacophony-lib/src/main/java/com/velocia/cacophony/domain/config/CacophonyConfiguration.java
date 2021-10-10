package com.velocia.cacophony.domain.config;

import com.velocia.cacophony.domain.event.EventRepeater;
import com.velocia.cacophony.domain.event.ListenerCaller;

public class CacophonyConfiguration {
    private static ListenerCaller listenerCaller;
    private static EventRepeater eventRepeater;

    public static ListenerCaller listenerCaller() {
        if(listenerCaller == null) listenerCaller = new ListenerCaller();
        return listenerCaller;
    }

    public static EventRepeater eventRepeater() {
        if(eventRepeater == null) eventRepeater = new EventRepeater(listenerCaller());
        return eventRepeater;
    }
}

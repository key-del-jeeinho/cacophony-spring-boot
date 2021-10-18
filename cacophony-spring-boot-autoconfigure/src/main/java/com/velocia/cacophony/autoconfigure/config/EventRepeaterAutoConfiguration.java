package com.velocia.cacophony.autoconfigure.config;

import com.velocia.cacophony.domain.event.EventRepeater;
import com.velocia.cacophony.domain.event.ListenerCaller;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EventRepeaterAutoConfiguration {
    private final ListenerCaller listenerCaller;

    @Bean
    public EventRepeater eventRepeater() {
        return new EventRepeater(listenerCaller);
    }
}

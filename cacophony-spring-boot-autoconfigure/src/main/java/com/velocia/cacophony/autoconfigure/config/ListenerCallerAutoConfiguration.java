package com.velocia.cacophony.autoconfigure.config;

import com.velocia.cacophony.domain.event.ListenerCaller;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ListenerCallerAutoConfiguration {
    @Bean
    public ListenerCaller listenerCaller() {
        return new ListenerCaller();
    }
}

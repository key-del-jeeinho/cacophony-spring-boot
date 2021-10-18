package com.velocia.cacophony.autoconfigure.config;

import com.velocia.cacophony.domain.event.ListenerCaller;
import com.velocia.cacophony.domain.flow.FlowBuilderGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StaticInitializationAutoConfiguration {
    private final ListenerCaller listenerCaller;
    @Bean
    public FlowBuilderGenerator flowBuilderGenerator() {
        return FlowBuilderGenerator.init((listenerCaller));
    }
}

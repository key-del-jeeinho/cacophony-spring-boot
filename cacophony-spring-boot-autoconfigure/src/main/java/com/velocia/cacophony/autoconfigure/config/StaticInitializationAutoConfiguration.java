package com.velocia.cacophony.autoconfigure.config;

import com.velocia.cacophony.domain.event.ListenerCaller;
import com.velocia.cacophony.domain.flow.FlowBuilderGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * StaticClass 들의 구성정보를 초기화하기 위한 Configuration입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@RequiredArgsConstructor
public class StaticInitializationAutoConfiguration {
    private final ListenerCaller listenerCaller;

    @Bean
    public FlowBuilderGenerator flowBuilderGenerator() {
        return FlowBuilderGenerator.init((listenerCaller));
    }
}

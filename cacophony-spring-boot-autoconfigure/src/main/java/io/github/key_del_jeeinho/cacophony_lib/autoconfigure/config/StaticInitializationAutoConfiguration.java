package io.github.key_del_jeeinho.cacophony_lib.autoconfigure.config;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowBuilderGenerator;
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
        FlowBuilderGenerator.init((listenerCaller));
        return new FlowBuilderGenerator();
    }
}

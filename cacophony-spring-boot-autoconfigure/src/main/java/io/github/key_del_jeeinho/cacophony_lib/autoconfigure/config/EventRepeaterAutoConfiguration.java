package io.github.key_del_jeeinho.cacophony_lib.autoconfigure.config;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.EventRepeater;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * EventRepeater 를 사용하기 위한 Configuration입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@RequiredArgsConstructor
public class EventRepeaterAutoConfiguration {
    private final ListenerCaller listenerCaller;

    @Bean
    public EventRepeater eventRepeater() {
        return new EventRepeater(listenerCaller);
    }
}

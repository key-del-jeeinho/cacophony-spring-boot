package io.github.key_del_jeeinho.cacophony_lib.autoconfigure.config;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ListenerCaller 를 사용하기 위한 Configuration입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@RequiredArgsConstructor
public class ListenerCallerAutoConfiguration {
    @Bean
    public ListenerCaller listenerCaller() {
        return new ListenerCaller();
    }
}

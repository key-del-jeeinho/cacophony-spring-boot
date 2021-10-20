package io.github.key_del_jeeinho.cacophony_lib.autoconfigure.config;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater.JoinQuitEventRepeater;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater.ChatEventRepeater;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater.ReactEventRepeater;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
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
    private final JDA jda;

    @Bean
    public JoinQuitEventRepeater joinQuitEventRepeater() {
        JoinQuitEventRepeater repeater = new JoinQuitEventRepeater(listenerCaller);
        jda.addEventListener(repeater);
        return repeater;
    }

    @Bean
    public ChatEventRepeater chatEventRepeater() {
        ChatEventRepeater repeater = new ChatEventRepeater(listenerCaller);
        jda.addEventListener(repeater);
        return repeater;
    }

    @Bean
    public ReactEventRepeater reactEventRepeater() {
        ReactEventRepeater repeater = new ReactEventRepeater(listenerCaller);
        jda.addEventListener(repeater);
        return repeater;
    }
}

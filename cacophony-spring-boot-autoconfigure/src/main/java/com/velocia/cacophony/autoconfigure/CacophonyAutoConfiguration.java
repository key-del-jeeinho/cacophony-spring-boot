package com.velocia.cacophony.autoconfigure;

import com.velocia.cacophony.domain.event.EventRepeater;
import com.velocia.cacophony.domain.event.ListenerCaller;
import com.velocia.cacophony.domain.flow.FlowBuilderGenerator;
import com.velocia.cacophony.global.exception.BotCreationFailureException;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;

/**
 * Cacophony configuration for beans
 *
 * @author velocia
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@EnableConfigurationProperties(CacophonyProperties.class)
@RequiredArgsConstructor
public class CacophonyAutoConfiguration {
    private final CacophonyProperties cacophonyProperties;

    private static JDA jda;
    private static EventRepeater eventRepeater;
    private static ListenerCaller listenerCaller;
    private static FlowBuilderGenerator flowBuilderGenerator;

    @Bean @ConditionalOnMissingBean
    public JDA jda() {
        if(jda == null) initJda();
        return jda;
    }

    private void initJda() {
        try {
            jda = JDABuilder.createDefault(cacophonyProperties.getToken()).build();
        } catch (LoginException e) {
            throw new BotCreationFailureException(e);
        }
    }

    @Bean
    public EventRepeater eventRepeater() {
        if(eventRepeater == null) initEventRepeater();
        return eventRepeater;
    }

    private void initEventRepeater() {
        eventRepeater = new EventRepeater(listenerCaller());
    }

    @Bean
    public ListenerCaller listenerCaller() {
        if(listenerCaller == null) initListenerCaller();
        return listenerCaller;
    }

    private void initListenerCaller() {
        throw new RuntimeException();
//        listenerCaller = new ListenerCaller();
    }

    @Bean
    public FlowBuilderGenerator flowBuilderGenerator() {
        if(flowBuilderGenerator == null) flowBuilderGenerator = new FlowBuilderGenerator(listenerCaller());
        return flowBuilderGenerator;
    }
}

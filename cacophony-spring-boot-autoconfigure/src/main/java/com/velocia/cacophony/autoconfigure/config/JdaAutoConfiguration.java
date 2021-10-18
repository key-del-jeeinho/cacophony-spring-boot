package com.velocia.cacophony.autoconfigure.config;

import com.velocia.cacophony.autoconfigure.prop.CacophonyProperties;
import com.velocia.cacophony.domain.event.EventRepeater;
import com.velocia.cacophony.global.exception.BotCreationFailureException;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;

@Configuration
@EnableConfigurationProperties(CacophonyProperties.class)
@RequiredArgsConstructor
public class JdaAutoConfiguration {
    private final CacophonyProperties cacophonyProperties;
    private final EventRepeater eventRepeater;

    @Bean @ConditionalOnMissingBean
    public JDA jda() {
        JDA jda;

        try {
            jda = JDABuilder.createDefault(cacophonyProperties.getToken()).build();
            jda.addEventListener(eventRepeater);
        } catch (LoginException e) {
            throw new BotCreationFailureException(e);
        }

        return jda;
    }
}

package com.velocia.cacophony.autoconfigure;

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

    //Write beans here!
    @Bean @ConditionalOnMissingBean
    public JDA jda() throws LoginException {
        return JDABuilder.createDefault(cacophonyProperties.getToken()).build();
    }
}

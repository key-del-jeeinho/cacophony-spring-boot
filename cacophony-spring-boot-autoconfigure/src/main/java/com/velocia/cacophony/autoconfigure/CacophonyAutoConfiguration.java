package com.velocia.cacophony.autoconfigure;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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
}

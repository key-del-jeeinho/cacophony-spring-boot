package com.velocia.cacophony.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties for auto configuration
 *
 * @author velocia
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@ConfigurationProperties(prefix = "cacophony")
@Getter @Setter
public class CacophonyProperties {
    private String token;
}

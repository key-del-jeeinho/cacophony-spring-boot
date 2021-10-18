package com.velocia.cacophony.autoconfigure.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Cacophony API 에서 사용되는 구성정보를 세팅하기위한 SpringProperty 입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@ConfigurationProperties(prefix = "cacophony")
@Getter @Setter
public class CacophonyProperties {
    private String token;
}

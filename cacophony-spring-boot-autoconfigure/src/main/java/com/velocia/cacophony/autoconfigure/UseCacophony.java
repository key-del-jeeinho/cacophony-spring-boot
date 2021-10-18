package com.velocia.cacophony.autoconfigure;

import com.velocia.cacophony.autoconfigure.config.EventRepeaterAutoConfiguration;
import com.velocia.cacophony.autoconfigure.config.JdaAutoConfiguration;
import com.velocia.cacophony.autoconfigure.config.ListenerCallerAutoConfiguration;
import com.velocia.cacophony.autoconfigure.config.StaticInitializationAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Cacophony API 를 Spring 에서 이용하기 위한 Annotation 입니다.
 * SpringBootApplication 어노테이션이 사용되는 클래스 즉, Main 클래스에 붙여서 사용하시면 됩니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({EventRepeaterAutoConfiguration.class, StaticInitializationAutoConfiguration.class, JdaAutoConfiguration.class, ListenerCallerAutoConfiguration.class})
public @interface UseCacophony {
}

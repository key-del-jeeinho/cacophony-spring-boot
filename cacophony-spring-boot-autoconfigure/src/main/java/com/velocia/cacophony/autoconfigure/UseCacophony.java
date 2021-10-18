package com.velocia.cacophony.autoconfigure;

import com.velocia.cacophony.autoconfigure.config.EventRepeaterAutoConfiguration;
import com.velocia.cacophony.autoconfigure.config.JdaAutoConfiguration;
import com.velocia.cacophony.autoconfigure.config.ListenerCallerAutoConfiguration;
import com.velocia.cacophony.autoconfigure.config.StaticInitializationAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({EventRepeaterAutoConfiguration.class, StaticInitializationAutoConfiguration.class, JdaAutoConfiguration.class, ListenerCallerAutoConfiguration.class})
public @interface UseCacophony {
}

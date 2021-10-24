package io.github.key_del_jeeinho.cacophony_lib.global.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Cacophony 라이브러리에 접근하는 Static method 들에 작성하는 Annotation 입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EntryPoint {
}

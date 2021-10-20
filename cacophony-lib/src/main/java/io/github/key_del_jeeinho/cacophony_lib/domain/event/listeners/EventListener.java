package io.github.key_del_jeeinho.cacophony_lib.domain.event.listeners;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.Event;

/**
 * 발생한 이벤트에 대한 처리를 담는 FunctionalInterface 입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@FunctionalInterface
public interface EventListener<T extends Event> {
    void call(T event);
    default T getInstance() {
        return (T)new Event(){};
    }
}

package com.velocia.cacophony.domain.listener;

import com.velocia.cacophony.domain.event.events.Event;

/**
 * 발생한 이벤트에 대한 처리를 담는 FunctionalInterface 입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@FunctionalInterface
public interface EventListener<T extends Event> {
    void call(T event);
}

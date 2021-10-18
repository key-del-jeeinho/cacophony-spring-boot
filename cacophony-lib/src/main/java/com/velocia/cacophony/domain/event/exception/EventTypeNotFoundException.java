package com.velocia.cacophony.domain.event.exception;

import com.velocia.cacophony.domain.event.events.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 빌셍한 Event 의 형식을 찾을 수 없을경우 발생하는 예외입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@RequiredArgsConstructor
public class EventTypeNotFoundException extends RuntimeException {
    @Getter
    private final Class<? extends Event> clazz;
}

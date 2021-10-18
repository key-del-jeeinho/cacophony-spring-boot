package com.velocia.cacophony.domain.event.exception;

import com.velocia.cacophony.domain.event.enum_type.EventType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 빌셍한 Event 의 형식에 대한 정의를 찾을 수 없을경우 발생하는 예외입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@RequiredArgsConstructor
@Getter
public class EventTypeNotDefinedException extends RuntimeException {
    private final EventType target;
}

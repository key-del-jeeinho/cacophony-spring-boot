package com.velocia.cacophony.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 디스코드 에서 유저가 보낸 메세지에 대한 정보를 저장하는 Dto 입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@RequiredArgsConstructor
@Getter
public class MessageDto {
    private final String message;
}

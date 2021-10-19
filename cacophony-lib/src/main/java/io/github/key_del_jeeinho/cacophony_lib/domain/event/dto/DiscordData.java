package io.github.key_del_jeeinho.cacophony_lib.domain.event.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 모든 디스코드 데이터를 담는 Dto 가 공통적으로 상속하는 클래스입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@RequiredArgsConstructor
@Getter
public class DiscordData {
    private final long id;
}

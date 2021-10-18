package com.velocia.cacophony.domain.event.events;

import com.velocia.cacophony.domain.dto.ServerDto;
import com.velocia.cacophony.domain.dto.UserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 유저가 서버에 입장했을때 발생하는 이벤트입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@RequiredArgsConstructor
@Getter
public class JoinEvent implements Event {
    private final UserDto user;
    private final ServerDto server;
}

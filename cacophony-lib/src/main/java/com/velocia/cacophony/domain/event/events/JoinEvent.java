package com.velocia.cacophony.domain.event.events;

import com.velocia.cacophony.domain.dto.ServerDto;
import com.velocia.cacophony.domain.dto.UserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class JoinEvent implements Event {
    private final UserDto user;
    private final ServerDto server;
}

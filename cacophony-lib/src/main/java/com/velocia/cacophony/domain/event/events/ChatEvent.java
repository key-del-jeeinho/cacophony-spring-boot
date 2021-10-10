package com.velocia.cacophony.domain.event.events;

import com.velocia.cacophony.domain.dto.ChannelDto;
import com.velocia.cacophony.domain.dto.UserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ChatEvent implements Event {
    private final ChannelDto channel;
    private final UserDto user;
}

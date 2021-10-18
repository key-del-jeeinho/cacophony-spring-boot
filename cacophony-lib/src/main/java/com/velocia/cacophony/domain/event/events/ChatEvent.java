package com.velocia.cacophony.domain.event.events;

import com.velocia.cacophony.domain.event.dto.ChannelDto;
import com.velocia.cacophony.domain.event.dto.UserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Message;

/**
 * 유저가 채팅을 쳤을때 발생하는 이벤트입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@RequiredArgsConstructor
@Getter
public class ChatEvent implements Event {
    private final ChannelDto channel;
    private final UserDto author;
    private final Message message;
}

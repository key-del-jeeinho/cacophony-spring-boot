package io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat;

import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.MessageDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
    private final MessageDto message;
    private final EventType eventType;

    public enum EventType {
        WRITE, EDIT, DELETE
    }
}

package io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react;

import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.ServerDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.MessageDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 메세지에 반응이 변화하였을경우 발생하는 이벤트입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@RequiredArgsConstructor
@Getter
public class ReactEvent implements Event {
    private final MessageDto message;
    private final UserDto reactor;
    private final String emote;
    private final EventType eventType;
    private final ChannelDto channel;

    public enum EventType {
        ADD, REMOVE
    }
}

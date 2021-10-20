package io.github.key_del_jeeinho.cacophony_lib.domain.event.events;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message.EmbedMessageDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message.MessageDto;
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

    public enum EventType {
        ADD, REMOVE
    }
}

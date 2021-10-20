package io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message.MessageDto;

/**
 * 서버 내에 존재하는 메세지에 반응이 변화하였을경우 발생하는 이벤트입니다.
 *
 * @author JeeInho
 * @since 1.0.2-RELEASE
 */
public class ServerReactEvent extends ReactEvent{
    public ServerReactEvent(MessageDto message, UserDto reactor, String emote, EventType eventType) {
        super(message, reactor, emote, eventType);
    }
}

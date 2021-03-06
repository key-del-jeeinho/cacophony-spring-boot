package io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react;

import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.ServerDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.MessageDto;

/**
 * 개인DM 에 반응이 변화하였을경우 발생하는 이벤트입니다.
 *
 * @author JeeInho
 * @since 1.0.2-RELEASE
 */
public class PrivateReactEvent extends ReactEvent{
    public PrivateReactEvent(MessageDto message, UserDto reactor, String emote, EventType eventType, ChannelDto channel) {
        super(message, reactor, emote, eventType, channel);
    }
}

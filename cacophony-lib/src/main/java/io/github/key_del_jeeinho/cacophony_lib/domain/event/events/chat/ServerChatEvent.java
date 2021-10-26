package io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat;

import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.MessageDto;

/**
 * 유저가 서버 내에서 채팅을 쳤을때 발생하는 이벤트입니다.
 *
 * @author JeeInho
 * @since 1.0.2-RELEASE
 */
public class ServerChatEvent extends ChatEvent{
    public ServerChatEvent(ChannelDto channel, UserDto author, MessageDto message, EventType eventType) {
        super(channel, author, message, eventType);
    }
}

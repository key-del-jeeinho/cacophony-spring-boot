package io.github.key_del_jeeinho.cacophony_lib.domain.command.component;

import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;

@FunctionalInterface
public interface CommandAction {
    void accept(Argument argument, UserDto author, ChannelDto channel);
}

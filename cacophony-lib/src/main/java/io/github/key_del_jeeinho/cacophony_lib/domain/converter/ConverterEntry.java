package io.github.key_del_jeeinho.cacophony_lib.domain.converter;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.enum_type.ChannelType;
import io.github.key_del_jeeinho.cacophony_lib.global.annotation.EntryPoint;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.ServerDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class ConverterEntry {
    @EntryPoint
    public static ServerDto roleToServer(long roleId) {
        return ConverterGenerator.generateDefault().roleToServer(roleId);
    }

    @EntryPoint
    public static ServerDto channelToServer(long channelId) {
        return ConverterGenerator.generateDefault().channelToServer(channelId);
    }

    public static ChannelDto userToDM(long userId) {
        return ConverterGenerator.generateDefault().userToDM(userId);
    }

    public static UserDto userById(long userId) {
        return ConverterGenerator.generateDefault().userById(userId);
    }

    public static ChannelDto channelById(long channelId, ChannelType channelType) {
        return ConverterGenerator.generateDefault().channelById(channelId, channelType);
    }

    public static ServerDto serverById(long serverId) {
        return ConverterGenerator.generateDefault().serverById(serverId);
    }
}

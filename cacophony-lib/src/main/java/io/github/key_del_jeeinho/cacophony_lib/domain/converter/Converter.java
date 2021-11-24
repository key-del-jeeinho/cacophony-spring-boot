package io.github.key_del_jeeinho.cacophony_lib.domain.converter;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.enum_type.ChannelType;
import io.github.key_del_jeeinho.cacophony_lib.global.annotation.EntryPoint;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.ServerDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.global.exception.ChannelNotFoundException;
import io.github.key_del_jeeinho.cacophony_lib.global.exception.RoleNotFoundException;
import io.github.key_del_jeeinho.cacophony_lib.global.exception.ServerNotFoundException;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;

@RequiredArgsConstructor
public class Converter {
    private final JDA jda;
    
    @EntryPoint
    public ServerDto roleToServer(long roleId) {
        Role role = jda.getRoleById(roleId);
        if(role == null) throw new RoleNotFoundException(roleId);
        Guild guild = role.getGuild();

        return new ServerDto(guild.getIdLong());
    }

    @EntryPoint
    public ServerDto channelToServer(long channelId) {
        GuildChannel channel = jda.getGuildChannelById(channelId);
        if(channel == null) throw new ChannelNotFoundException(channelId);
        Guild guild = channel.getGuild();

        return new ServerDto(guild.getIdLong());
    }

    public ChannelDto userToDM(long userId) {
        PrivateChannel channel = jda.retrieveUserById(userId).complete()
                .openPrivateChannel().complete();
        return new ChannelDto(channel.getIdLong(), channel.getName(), ChannelType.PRIVATE);
    }

    public UserDto userById(long userId) {
        User user = jda.retrieveUserById(userId).complete();
        return new UserDto(user.getIdLong());
    }

    public ChannelDto channelById(long channelId, ChannelType channelType) {
        MessageChannel channel = switch (channelType) {
            case SERVER -> jda.getTextChannelById(channelId);
            case PRIVATE -> jda.getPrivateChannelById(channelId);
        };

        if(channel == null) throw new ChannelNotFoundException(channelId);

        return new ChannelDto(channel.getIdLong(), channel.getName(), channelType);
    }

    public ServerDto serverById(long serverId) {
        Guild guild = jda.getGuildById(serverId);
        if(guild == null) throw new ServerNotFoundException(serverId);

        return new ServerDto(guild.getIdLong());
    }
}

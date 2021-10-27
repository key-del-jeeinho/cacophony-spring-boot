package io.github.key_del_jeeinho.cacophony_lib.domain.action;

import io.github.key_del_jeeinho.cacophony_lib.domain.action.exception.ChannelNotFoundException;
import io.github.key_del_jeeinho.cacophony_lib.domain.action.exception.RoleNotFoundException;
import io.github.key_del_jeeinho.cacophony_lib.domain.action.exception.ServerNotFoundException;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.RoleDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.EmbedMessageDto;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

@RequiredArgsConstructor
public class ActionBuilder {
    private final JDA jda;

    public void chat(String message, long channelId) {
        getChannelById(channelId)
                .sendMessage(message).complete();
    }

    public void chat(EmbedMessageDto embedMessage, long channelId) {
        getChannelById(channelId).sendMessageEmbeds(embedMessage.toEmbed()).complete();
    }

    public void react(String emote, long messageId, long channelId) {
        Message message = getChannelById(channelId)
                .retrieveMessageById(messageId).complete();
        message.addReaction(emote).complete();
    }

    public void ban(long userId, long serverId) {
        getServerById(serverId).ban(Long.toString(userId), 0).complete();
    }

    public void grantRole(long roleId, long userId, long serverId) {
        Role role = getRoleById(serverId, roleId);
        getServerById(serverId).addRoleToMember(userId, role).complete();
    }

    public RoleDto createRole(RoleDto role, long serverId) {
        Guild guild = getServerById(serverId);
        long roleId = guild.createRole()
                .setName(role.getName())
                .setColor(role.getColor())
                .setPermissions(role.getPermissions())
                .complete().getIdLong();
        return new RoleDto(roleId, role.getName(), role.getColor(), role.getPermissions());
    }

    private Role getRoleById(long serverId, long roleId) {
        Role role = getServerById(serverId).getRoleById(roleId);
        if(role == null) throw new RoleNotFoundException(roleId);

        return role;
    }

    private Guild getServerById(long serverId) {
        Guild guild = jda.getGuildById(serverId);
        if(guild == null) throw new ServerNotFoundException(serverId);

        return guild;
    }

    private TextChannel getChannelById(long channelId) {
        TextChannel channel = jda.getTextChannelById(channelId);
        if(channel == null) throw new ChannelNotFoundException(channelId);

        return channel;
    }
}

package io.github.key_del_jeeinho.cacophony_lib.domain.action;

import io.github.key_del_jeeinho.cacophony_lib.global.exception.ChannelNotFoundException;
import io.github.key_del_jeeinho.cacophony_lib.global.exception.RoleNotFoundException;
import io.github.key_del_jeeinho.cacophony_lib.global.exception.ServerNotFoundException;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.RoleDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.EmbedMessageDto;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;

@RequiredArgsConstructor
public class Action {
    private final JDA jda;

    public long chat(String message, long channelId) {
        return getChannelById(channelId)
                .sendMessage(message).complete().getIdLong();
    }

    public long chat(EmbedMessageDto embedMessage, long channelId) {
        return getChannelById(channelId)
                .sendMessageEmbeds(embedMessage.toEmbed()).complete().getIdLong();
    }

    public void react(String emote, long messageId, long channelId) {
        Message message = getChannelById(channelId)
                .retrieveMessageById(messageId).complete();
        message.addReaction(emote).complete();
    }

    public void ban(long userId, long serverId) {
        getServerById(serverId).ban(Long.toString(userId), 0).complete();
    }

    public void pardon(long userId, long serverId) {
        getServerById(serverId).unban(Long.toString(userId)).complete();
    }

    public void grantRole(long roleId, long userId, long serverId) {
        Role role = getRoleById(serverId, roleId);
        getServerById(serverId).addRoleToMember(userId, role).complete();
    }

    public void createRole(RoleDto role, long serverId) {
        Guild guild = getServerById(serverId);
        guild.createRole()
                .setName(role.getName())
                .setColor(role.getColor())
                .setPermissions(role.getPermissions())
                .complete();
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

    private MessageChannel getChannelById(long channelId) {
        MessageChannel channel = jda.getTextChannelById(channelId);
        if(channel == null)
            channel = jda.getPrivateChannelById(channelId);
        if(channel == null) throw new ChannelNotFoundException(channelId);

        return channel;
    }
}

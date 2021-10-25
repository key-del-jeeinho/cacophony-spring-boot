package io.github.key_del_jeeinho.cacophony_lib.domain.action;

import io.github.key_del_jeeinho.cacophony_lib.domain.action.exception.ChannelNotFoundException;
import io.github.key_del_jeeinho.cacophony_lib.domain.action.exception.GuildNotFoundException;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.RoleDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.EmbedMessageDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.NotNull;

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
        getServerById(serverId).createRole()
                //TODO
                .complete();
    }

    public void createRole(RoleDto role, long serverId) {
        //TODO
    }

    private Guild getServerById(long serverId) {
        Guild guild = jda.getGuildById(serverId);
        if(guild == null) throw new GuildNotFoundException(serverId);

        return guild;
    }

    private TextChannel getChannelById(long channelId) {
        TextChannel channel = jda.getTextChannelById(channelId);
        if(channel == null) throw new ChannelNotFoundException(channelId);

        return channel;
    }
}

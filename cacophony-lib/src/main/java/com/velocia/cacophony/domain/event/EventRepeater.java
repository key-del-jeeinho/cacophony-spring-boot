package com.velocia.cacophony.domain.event;

import com.velocia.cacophony.domain.dto.ChannelDto;
import com.velocia.cacophony.domain.dto.MessageDto;
import com.velocia.cacophony.domain.dto.ServerDto;
import com.velocia.cacophony.domain.dto.UserDto;
import com.velocia.cacophony.domain.event.events.ChatEvent;
import com.velocia.cacophony.domain.event.events.JoinEvent;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * JDA 에서 발생한 Event 를 CacophonyEvent 로 바꾸어서 중계(Repeat) 해주는 클래스입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@RequiredArgsConstructor
public class EventRepeater extends ListenerAdapter {
    private final ListenerCaller listenerCaller;

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
        UserDto user = new UserDto();
        ChannelDto channel = new ChannelDto();
        MessageDto message = new MessageDto(event.getMessage().getContentRaw());
        listenerCaller.callEvent(new ChatEvent(channel, user, message));
    }

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        super.onGuildJoin(event);
        UserDto user = new UserDto();
        ServerDto server = new ServerDto();
        listenerCaller.callEvent(new JoinEvent(user, server));
    }
}

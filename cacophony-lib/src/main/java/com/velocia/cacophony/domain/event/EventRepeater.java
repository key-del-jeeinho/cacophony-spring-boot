package com.velocia.cacophony.domain.event;

import com.velocia.cacophony.domain.dto.ChannelDto;
import com.velocia.cacophony.domain.dto.UserDto;
import com.velocia.cacophony.domain.event.events.ChatEvent;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class EventRepeater extends ListenerAdapter {
    private final ListenerCaller listenerCaller;

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
        UserDto user = new UserDto();
        ChannelDto channel = new ChannelDto();
        listenerCaller.callEvent(new ChatEvent(channel, user));
    }

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        super.onGuildJoin(event);

    }
}

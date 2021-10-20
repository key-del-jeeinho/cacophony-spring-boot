package io.github.key_del_jeeinho.cacophony_lib.domain.event;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.ServerDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message.EmbedMessageDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message.MessageDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.enum_type.ChannelType;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.JoinEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.QuitEvent;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.message.guild.*;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageEmbedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageUpdateEvent;
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
        callChatEvent(event.getAuthor(), event.getChannel(), event.getMessage(), ChatEvent.EventType.WRITE);
    }

    @Override
    public void onGuildMessageUpdate(@NotNull GuildMessageUpdateEvent event) {
        super.onGuildMessageUpdate(event);
        callChatEvent(event.getAuthor(), event.getChannel(), event.getMessage(), ChatEvent.EventType.WRITE);
    }

    @Override
    public void onGuildMessageDelete(@NotNull GuildMessageDeleteEvent event) {
        super.onGuildMessageDelete(event);
        callChatEvent(null, event.getChannel(), event.getMessageIdLong(), null, ChatEvent.EventType.DELETE);
    }

    @Override
    public void onPrivateMessageReceived(@NotNull PrivateMessageReceivedEvent event) {
        super.onPrivateMessageReceived(event);
        callChatEvent(null, (TextChannel) event.getChannel(), event.getMessageIdLong(), null,  ChatEvent.EventType.WRITE);
    }

    @Override
    public void onPrivateMessageUpdate(@NotNull PrivateMessageUpdateEvent event) {
        super.onPrivateMessageUpdate(event);
        callChatEvent(event.getAuthor(), (TextChannel) event.getChannel(), event.getMessage(), ChatEvent.EventType.EDIT);
    }

    @Override
    public void onPrivateMessageDelete(@NotNull PrivateMessageDeleteEvent event) {
        super.onPrivateMessageDelete(event);
        callChatEvent(null, (TextChannel) event.getChannel(), event.getMessageIdLong(), null,  ChatEvent.EventType.DELETE);
    }

    private void callChatEvent(User author, TextChannel textChannel, Message message, ChatEvent.EventType eventType) {
        callChatEvent(author, textChannel, message.getIdLong(), message.getContentRaw(), eventType);
    }
    private void callChatEvent(User author, TextChannel textChannel, long messageId, String message, ChatEvent.EventType eventType) {
        UserDto user = new UserDto(author.getIdLong());
        ChannelDto channel = new ChannelDto(
                textChannel.getIdLong(),
                ChannelType.of(textChannel.getType()),
                textChannel.getName()
        );
        MessageDto msg = new MessageDto(messageId, message);
        listenerCaller.callEvent(new ChatEvent(channel, user, msg, eventType));
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        super.onGuildMemberJoin(event);
        UserDto user = new UserDto(event.getUser().getIdLong());
        ServerDto server = new ServerDto(event.getGuild().getIdLong());
        listenerCaller.callEvent(new JoinEvent(user, server));
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        super.onGuildMemberRemove(event);
        UserDto user = new UserDto(event.getUser().getIdLong());
        ServerDto server = new ServerDto(event.getGuild().getIdLong());
        listenerCaller.callEvent(new QuitEvent(user, server));
    }
}

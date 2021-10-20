package io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message.MessageDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.enum_type.ChannelType;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.ChatEvent;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * JDA 에서 발생한 채팅 관련 Event 를 CacophonyEvent 로 바꾸어서 중계(Repeat) 해주는 클래스입니다.
 *
 * @author JeeInho
 * @since 1.0.1-SNAPSHOT
 */
@RequiredArgsConstructor
public class ChatEventRepeater extends ListenerAdapter {
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
        UserDto user;
        if(author != null)
            user = new UserDto(author.getIdLong());
        else user = new UserDto(-1);
        ChannelDto channel = new ChannelDto(
                textChannel.getIdLong(),
                ChannelType.of(textChannel.getType()),
                textChannel.getName()
        );
        MessageDto msg = new MessageDto(messageId, message);
        listenerCaller.callEvent(
                new ChatEvent(channel, user, msg, eventType)
        );
    }
}

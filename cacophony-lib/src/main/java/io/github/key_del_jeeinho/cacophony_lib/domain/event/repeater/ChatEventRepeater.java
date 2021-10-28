package io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.MessageDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.enum_type.ChannelType;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.PrivateChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ServerChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.exception.ChatTypeNotDefinedException;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
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
        callChatEvent(event.getAuthor(), event.getChannel(), event.getMessage(), ChatEvent.EventType.WRITE, ChatType.SERVER);
    }

    @Override
    public void onGuildMessageUpdate(@NotNull GuildMessageUpdateEvent event) {
        super.onGuildMessageUpdate(event);
        callChatEvent(event.getAuthor(), event.getChannel(), event.getMessage(), ChatEvent.EventType.WRITE, ChatType.SERVER);
    }

    @Override
    public void onGuildMessageDelete(@NotNull GuildMessageDeleteEvent event) {
        super.onGuildMessageDelete(event);
        callChatEvent(null, event.getChannel(), event.getMessageIdLong(), null, ChatEvent.EventType.DELETE, ChatType.SERVER);
    }

    @Override
    public void onPrivateMessageReceived(@NotNull PrivateMessageReceivedEvent event) {
        super.onPrivateMessageReceived(event);
        callChatEvent(null, event.getChannel(), event.getMessageIdLong(), null,  ChatEvent.EventType.WRITE, ChatType.PRIVATE);
    }

    @Override
    public void onPrivateMessageUpdate(@NotNull PrivateMessageUpdateEvent event) {
        super.onPrivateMessageUpdate(event);
        callChatEvent(event.getAuthor(), event.getChannel(), event.getMessage(), ChatEvent.EventType.EDIT, ChatType.PRIVATE);
    }

    @Override
    public void onPrivateMessageDelete(@NotNull PrivateMessageDeleteEvent event) {
        super.onPrivateMessageDelete(event);
        callChatEvent(null, event.getChannel(), event.getMessageIdLong(), null,  ChatEvent.EventType.DELETE, ChatType.PRIVATE);
    }

    private void callChatEvent(User author, MessageChannel messageChannel, Message message, ChatEvent.EventType eventType, ChatType chatType) {
        callChatEvent(author, messageChannel, message.getIdLong(), message.getContentRaw(), eventType, chatType);
    }
    private void callChatEvent(User author, MessageChannel messageChannel, long messageId, String message, ChatEvent.EventType eventType, ChatType chatType) {
        UserDto user;
        //delete event 같이 author 가 존재하지 않는경우, id 를 -1로 초기화한다
        if(author != null)
            user = new UserDto(author.getIdLong());
        else user = new UserDto(-1);

        //ChatEvent 에 들어갈 인자를 구성한다
        ChannelDto channel = new ChannelDto(
                        messageChannel.getIdLong(),
                messageChannel.getName(),
                ChannelType.of(messageChannel.getType())
                );
        MessageDto msg = new MessageDto(messageId, message);
        //ChatEvent 를 Calling 한다
        listenerCaller.callEvent(
                new ChatEvent(channel, user, msg, eventType)
        );

        //메세지 송신 위치에 따라, Private 혹은 Server Chat Event 를 Calling 한다
        ChatEvent event = switch (chatType) {
            case SERVER -> new ServerChatEvent(channel, user, msg, eventType);
            case PRIVATE -> new PrivateChatEvent(channel, user, msg, eventType);
            default -> throw new ChatTypeNotDefinedException(); //혹시 모를 경우를 대비해서 명시한 ChatType 이외의 chatType 이 들어온경우, Exception 을 반환한다
        };

        listenerCaller.callEvent(event);
    }

    private enum ChatType {
        PRIVATE, SERVER
    }
}

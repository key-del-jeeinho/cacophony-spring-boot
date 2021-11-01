package io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.enum_type.ChannelType;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.ServerDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.MessageDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.PrivateReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ServerReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.exception.ReactTypeNotDefinedException;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * JDA 에서 발생한 유저 Reaction 관련 Event 를 CacophonyEvent 로 바꾸어서 중계(Repeat) 해주는 클래스입니다.
 *
 * @author JeeInho
 * @since 1.0.1-SNAPSHOT
 */
@RequiredArgsConstructor
public class ReactEventRepeater extends ListenerAdapter {
    private final ListenerCaller listenerCaller;

    @Override
    public void onGuildMessageReactionAdd(@NotNull GuildMessageReactionAddEvent event) {
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.ADD, ChannelType.SERVER, event.getChannel());
        super.onGuildMessageReactionAdd(event);
    }

    @Override
    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.REMOVE, ChannelType.SERVER, event.getChannel());
        super.onGuildMessageReactionRemove(event);
    }

    @Override
    public void onPrivateMessageReactionAdd(@NotNull PrivateMessageReactionAddEvent event) {
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.ADD, ChannelType.PRIVATE, event.getChannel());
        super.onPrivateMessageReactionAdd(event);
    }

    @Override
    public void onPrivateMessageReactionRemove(@NotNull PrivateMessageReactionRemoveEvent event) {
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.REMOVE, ChannelType.PRIVATE, event.getChannel());
        super.onPrivateMessageReactionRemove(event);
    }

    public void callReactEvent(long messageId, String content, long userId, String emote, ReactEvent.EventType eventType, ChannelType reactAt, MessageChannel messageChannel) {
        //ReactEvent 에 들어갈 인자를 구성한다
        MessageDto message = new MessageDto(messageId, content);
        ChannelDto channel = new ChannelDto(messageChannel.getIdLong(), messageChannel.getName(), reactAt);
        UserDto user = new UserDto(userId);

        //ReactEvent 를 Calling 한다
        listenerCaller.callEvent(
                new ReactEvent(message, user, emote, eventType, channel)
        );

        //반응 발생 위치에 따라, Private 혹은 Server React Event 를 Calling 한다
        ReactEvent event = switch (reactAt) {
            case SERVER -> new ServerReactEvent(message, user, emote, eventType, channel);
            case PRIVATE -> new PrivateReactEvent(message, user, emote, eventType, channel);
            default -> throw new ReactTypeNotDefinedException(); //혹시 모를 경우를 대비해서 명시한 ReactType 이외의 reactAt 이 들어온경우, Exception 을 반환한다
        };

        listenerCaller.callEvent(event);
    }
}

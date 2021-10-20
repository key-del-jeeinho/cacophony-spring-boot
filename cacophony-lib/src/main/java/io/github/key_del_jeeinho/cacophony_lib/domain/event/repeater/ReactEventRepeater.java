package io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message.MessageDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.PrivateReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ServerReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.exception.ReactTypeNotDefinedException;
import lombok.RequiredArgsConstructor;
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
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.ADD, ReactType.SERVER);
        super.onGuildMessageReactionAdd(event);
    }

    @Override
    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.REMOVE, ReactType.SERVER);
        super.onGuildMessageReactionRemove(event);
    }

    @Override
    public void onPrivateMessageReactionAdd(@NotNull PrivateMessageReactionAddEvent event) {
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.ADD, ReactType.PRIVATE);
        super.onPrivateMessageReactionAdd(event);
    }

    @Override
    public void onPrivateMessageReactionRemove(@NotNull PrivateMessageReactionRemoveEvent event) {
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.REMOVE, ReactType.PRIVATE);
        super.onPrivateMessageReactionRemove(event);
    }

    public void callReactEvent(long messageId, String content, long userId, String emote, ReactEvent.EventType eventType, ReactType reactType) {
        //ReactEvent 에 들어갈 인자를 구성한다
        MessageDto message = new MessageDto(messageId, content);
        UserDto user = new UserDto(userId);

        //ReactEvent 를 Calling 한다
        listenerCaller.callEvent(
                new ReactEvent(message, user, emote, eventType)
        );

        //반응 발생 위치에 따라, Private 혹은 Server React Event 를 Calling 한다
        ReactEvent event = switch (reactType) {
            case SERVER -> new ServerReactEvent(message, user, emote, eventType);
            case PRIVATE -> new PrivateReactEvent(message, user, emote, eventType);
            default -> throw new ReactTypeNotDefinedException(); //혹시 모를 경우를 대비해서 명시한 ReactType 이외의 reactType 이 들어온경우, Exception 을 반환한다
        };

        listenerCaller.callEvent(event);
    }

    private enum ReactType {
        PRIVATE, SERVER
    }
}

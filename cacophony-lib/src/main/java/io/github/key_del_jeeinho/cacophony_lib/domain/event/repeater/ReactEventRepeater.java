package io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message.MessageDto;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.ReactEvent;
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
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.ADD);
        super.onGuildMessageReactionAdd(event);
    }

    @Override
    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.REMOVE);
        super.onGuildMessageReactionRemove(event);
    }

    @Override
    public void onPrivateMessageReactionAdd(@NotNull PrivateMessageReactionAddEvent event) {
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.ADD);
        super.onPrivateMessageReactionAdd(event);
    }

    @Override
    public void onPrivateMessageReactionRemove(@NotNull PrivateMessageReactionRemoveEvent event) {
        callReactEvent(event.getMessageIdLong(), null, event.getUserIdLong(), event.getReactionEmote().getName(), ReactEvent.EventType.REMOVE);
        super.onPrivateMessageReactionRemove(event);
    }

    public void callReactEvent(long messageId, String message, long userId, String emote, ReactEvent.EventType eventType) {
        listenerCaller.callEvent(
                new ReactEvent(
                        new MessageDto(messageId, message),
                        new UserDto(userId),
                        emote,
                        eventType
                )
        );
    }
}

package io.github.key_del_jeeinho.cacophony_lib.domain.command.component;

import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class CommandAdvice<T extends Throwable> {
    @Getter
    private final Class<T> throwable;
    private final CommandErrorAction<T> advice;

    private boolean canAdvice(Class<?> throwable) {
        return  this.throwable.isAssignableFrom(throwable);
    }

    private void apply(Argument argument, UserDto author, ChannelDto channel, T throwable) {
        this.advice.accept(argument, author, channel, throwable);
    }

    public boolean applyIfCan(Argument argument, UserDto author, ChannelDto channel, Throwable throwable) {
        if(canAdvice(throwable.getClass())) {
            apply(argument, author, channel, this.throwable.cast(throwable));
            return true;
        } else return false;
    }
}

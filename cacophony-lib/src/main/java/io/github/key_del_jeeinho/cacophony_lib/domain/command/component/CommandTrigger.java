package io.github.key_del_jeeinho.cacophony_lib.domain.command.component;

import lombok.RequiredArgsConstructor;

import java.util.function.Function;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class CommandTrigger implements Function<String, Boolean> {
    private final String trigger;
    private final boolean useRegex;

    @Override
    public Boolean apply(String s) {
        return useRegex ? Pattern.matches(trigger, s) : trigger.equals(s);
    }
}

package io.github.key_del_jeeinho.cacophony_lib.domain.command;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Argument;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Command;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.CommandAction;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.CommandTrigger;
import io.github.key_del_jeeinho.cacophony_lib.global.annotation.EntryPoint;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.AuthorDto;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CommandEntry {
    @EntryPoint
    public static RootCommand root(String rootPrefix, Command... commands) {
        return RootCommandGenerator.generateDefault(rootPrefix, commands);
    }

    @EntryPoint
    public static Command command(String prefix, Command... commands) {
        return command(prefix, Command.EMPTY_ACTION, commands);
    }

    @EntryPoint
    public static Command command(String prefix, CommandAction action, Command... commands) {
        Command command =  new Command(
                new CommandTrigger(prefix, false), action);
        command.addChildren(commands);

        return command;
    }

    @EntryPoint
    public static CommandAction action(Runnable action) {
        return (a, b, c) -> action.run();
    }

    @EntryPoint
    public static CommandAction action(Consumer<Argument> action) {
        return (argument, a, b) -> action.accept(argument);
    }

    @EntryPoint
    public static CommandAction action(BiConsumer<Argument, UserDto> action) {
        return (argument, author, a) -> action.accept(argument, author);
    }

    @EntryPoint
    public static CommandAction action(CommandAction action) {
        return action;
    }
}
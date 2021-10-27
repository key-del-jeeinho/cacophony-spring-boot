package io.github.key_del_jeeinho.cacophony_lib.domain.command;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Argument;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Command;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.CommandAction;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.CommandTrigger;
import io.github.key_del_jeeinho.cacophony_lib.global.annotation.EntryPoint;

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
        return vArgument -> action.run();
    }

    @EntryPoint
    public static CommandAction action(Consumer<Argument> action) {
        return action::accept;
    }
}
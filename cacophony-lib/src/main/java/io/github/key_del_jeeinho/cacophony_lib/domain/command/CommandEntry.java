package io.github.key_del_jeeinho.cacophony_lib.domain.command;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Command;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.CommandAction;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.CommandTrigger;
import io.github.key_del_jeeinho.cacophony_lib.domain.entry.annotation.EntryPoint;

public class CommandEntry {
    @EntryPoint
    public static RootCommandBuilder root(String rootPrefix, Command... commands) {
        return new RootCommandBuilder(rootPrefix, commands);
    }

    @EntryPoint
    public static Command command(String prefix, Command... commands) {
        Command command =  new Command(
                new CommandTrigger(prefix, false)
        );
        command.addChildren(commands);

        return command;
    }

    @EntryPoint
    public static Command action(CommandAction action) {
        return new Command(action);
    }

    @EntryPoint
    public static Command action(Runnable action) {
        return new Command(vArgument -> action.run());
    }
}
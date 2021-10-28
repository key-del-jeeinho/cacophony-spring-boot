package io.github.key_del_jeeinho.cacophony_lib.domain.command;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Command;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandManager;

public class RootCommandGenerator {
    private static CommandManager commandManager;

    public static RootCommand generateDefault(String rootPrefix, Command[] commands) {
        return new RootCommand(rootPrefix, commands, commandManager);
    }

    public static void init(CommandManager commandManager) {
        RootCommandGenerator.commandManager = commandManager;
    }
}

package io.github.key_del_jeeinho.cacophony_lib.domain.command;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Command;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandManager;

public class RootCommandBuilderGenerator {
    private static CommandManager commandManager;

    public static RootCommandBuilder generateDefault(String rootPrefix, Command[] commands) {
        return new RootCommandBuilder(rootPrefix, commands, commandManager);
    }

    public static void init(CommandManager commandManager) {
        RootCommandBuilderGenerator.commandManager = commandManager;
    }
}

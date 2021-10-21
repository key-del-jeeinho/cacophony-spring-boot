package io.github.key_del_jeeinho.cacophony_lib.domain.command;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Command;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.CommandTrigger;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandManager;

public class RootCommandBuilder {
    private final CommandManager commandManager;
    private final Command root;

    public RootCommandBuilder(String rootPrefix, Command[] commands, CommandManager commandManager) {
        root =  new Command(
                new CommandTrigger(rootPrefix, false));
        this.commandManager = commandManager;
        root.addChildren(commands);
    }

    public void complete() {
        commandManager.addRootCommand(root);
    }
}

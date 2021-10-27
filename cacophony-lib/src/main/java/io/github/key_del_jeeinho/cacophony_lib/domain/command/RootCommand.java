package io.github.key_del_jeeinho.cacophony_lib.domain.command;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Command;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.CommandTrigger;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandManager;

public class RootCommand {
    private final CommandManager commandManager;
    private final Command root;

    public RootCommand(String rootPrefix, Command[] commands, CommandManager commandManager) {
        root =  new Command(
                new CommandTrigger(rootPrefix, false));
        this.commandManager = commandManager;
        root.addChildren(commands);
    }

    public void complete() {
        System.out.println("새로운 root command 를 추가하였습니다!");
        System.out.printf("Manager : %s\n Command : %s%n", commandManager.toString(), root.toString());
        commandManager.addRootCommand(root);
    }
}

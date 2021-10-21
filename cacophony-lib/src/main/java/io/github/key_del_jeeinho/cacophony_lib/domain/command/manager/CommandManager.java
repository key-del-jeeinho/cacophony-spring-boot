package io.github.key_del_jeeinho.cacophony_lib.domain.command.manager;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Argument;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private final List<Command> roots;

    public CommandManager() {
        this.roots = new ArrayList<>();
    }

    public void addRootCommand(Command root) {
        roots.add(root);
    }

    public void execute(Argument input) {
        roots.forEach(root -> root.execute(input));
    }
}

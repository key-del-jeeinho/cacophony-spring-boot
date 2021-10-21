package io.github.key_del_jeeinho.cacophony_lib.domain.command.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {
    private final CommandTrigger trigger;
    private final CommandAction action;
    private final List<Command> children;

    public static final CommandTrigger EMPTY_TRIGGER = new CommandTrigger("^.*$", true);
    public static final CommandAction EMPTY_ACTION = argument -> {};

    public Command(CommandTrigger trigger, CommandAction action) {
        this.trigger = trigger;
        this.action = action;
        children = new ArrayList<>();
    }

    public Command(CommandTrigger trigger) {
        this(trigger, EMPTY_ACTION);
    }

    public Command(CommandAction action) {
        this(EMPTY_TRIGGER, action);
    }

    public void addChildren(Command[] commands) {
        children.addAll(Arrays.asList(commands));
    }

    public void execute(Argument argument) {
        //argument.initDepth(); //현재 송신된 인자를 root 로 가정한다
        if(!trigger.apply(argument.getArgument())) return; //만약 해당 커맨드의 prefix 가 아닐경우
        System.out.println("arg is " + argument.getArgument());
        action.accept(argument.getNext());

        if(!argument.isLeaf())
            children.forEach(child -> child.execute(argument.getNext()));
    }
}

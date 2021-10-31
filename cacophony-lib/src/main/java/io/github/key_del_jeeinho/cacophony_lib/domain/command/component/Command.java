package io.github.key_del_jeeinho.cacophony_lib.domain.command.component;

import io.github.key_del_jeeinho.cacophony_lib.global.dto.ChannelDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.UserDto;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/**
 * 명령어에 대한 정보를 담는 객체입니다.
 * Trigger-> Action and ChildrenCommand 로 이루어져있습니다
 * CommandEntry 를 통해 생성할 수 있습니다
 *
 * @see io.github.key_del_jeeinho.cacophony_lib.domain.command.CommandEntry#command(String, Command...)
 * @see io.github.key_del_jeeinho.cacophony_lib.domain.command.CommandEntry#command(String, CommandAction, Command...)
 *
 * @author JeeInho
 * @since 1.0.3-SNAPSHOT
 */
public class Command {
    private final CommandTrigger trigger;
    private final CommandAction action;
    private final List<Command> children;
    private final List<CommandAdvice> advices;

    public static final CommandTrigger EMPTY_TRIGGER = new CommandTrigger("^.*$", true);
    public static final CommandAction EMPTY_ACTION = (argument, author, channel) -> {};

    public Command(CommandTrigger trigger, CommandAction action) {
        this.trigger = trigger;
        this.action = action;
        children = new ArrayList<>();
        advices = new ArrayList<>();
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

    public <T extends Throwable> Command whenThrow(Class<T> throwable, Consumer<T> advice) {
        advices.add(new CommandAdvice<>(throwable, (a, b, c, exception) -> advice.accept(exception)));
        return this;
    }

    public <T extends Throwable> Command whenThrow(Class<T> throwable, CommandErrorAction<T> advice) {
        advices.add(new CommandAdvice<>(throwable, advice));
        return this;
    }

    public void execute(Argument argument, UserDto author, ChannelDto channel) {
        //argument.initDepth(); //현재 송신된 인자를 root 로 가정한다
        if(!trigger.apply(argument.getArgument())) return; //만약 해당 커맨드의 prefix 가 아닐경우
        try {
            action.accept(argument.getNext(), author, channel);
        } catch (Throwable throwable) {
            AtomicBoolean handled = new AtomicBoolean(false);
            advices.forEach(value -> {
                if(value.applyIfCan(argument, author, channel, throwable)) handled.set(true);
            });
            if(!handled.get()) throw throwable;
        }

        if(!argument.isLeaf())
            children.forEach(child -> child.execute(argument.getNext(), author, channel));
    }
}

package io.github.key_del_jeeinho.cacophony_lib.domain.command.manager;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Argument;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.listeners.EventListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowEntry.when;
import static io.github.key_del_jeeinho.cacophony_lib.domain.trigger.TriggerEntry.onChat;

public class CommandInputManager {
    private final CommandManager commandManager;

    public CommandInputManager(CommandManager commandManager) {
        this.commandManager = commandManager;
        when(
                onChat()
        ).doAction(
                (EventListener<ChatEvent>) event -> {
                    String chat = event.getMessage().getContent();
                    this.commandManager.execute(input(chat));
                }
        ).complete();
    }

    public Argument input(String input) {
        if(!input.contains(" ")) return new Argument(input);

        Argument argument = null;
        String[] reversedInputArgs = reverse(input.split(" ")); //leaf 먼저 설정하기위해 args 의 순서를 뒤집는다
        for (String arg : reversedInputArgs) {
            if(argument == null)
                argument = new Argument(arg);
            else argument = new Argument(arg, argument);
        }
        return argument;
    }

    private String[] reverse(String[] orign) {
        List<String> args = Arrays.asList(orign);
        Collections.reverse(args);
        return args.toArray(orign);
    }
}

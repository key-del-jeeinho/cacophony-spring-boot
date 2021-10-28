package io.github.key_del_jeeinho.cacophony_lib.global.config;

import io.github.key_del_jeeinho.cacophony_lib.domain.action.ActionGenerator;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.RootCommandGenerator;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandInputManager;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandManager;
import io.github.key_del_jeeinho.cacophony_lib.domain.converter.ConverterGenerator;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater.ChatEventRepeater;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater.JoinQuitEventRepeater;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater.ReactEventRepeater;
import io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowGenerator;
import io.github.key_del_jeeinho.cacophony_lib.global.exception.BotCreationFailureException;
import io.github.key_del_jeeinho.cacophony_lib.global.exception.UnusedConfigurationException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

//Vanilla Java 에서 Cacophony 를 사용할 수 있도록 해주는 클래스
public class CacophonyVanilla {
    private static boolean isUsed; //만약 해당 Config 를 통해 Cacophony 가 구동중일경우

    private static JDA jda;
    private static String token;

    private static ListenerCaller listenerCaller;

    private static ReactEventRepeater reactEventRepeater;
    private static ChatEventRepeater chatEventRepeater;
    private static JoinQuitEventRepeater joinQuitEventRepeater;

    private static CommandInputManager commandInputManager;
    private static CommandManager commandManager;

    public static void start(String token) {
        isUsed = true;
        CacophonyVanilla.token = token;

        FlowGenerator.init(listenerCaller());
        RootCommandGenerator.init(commandManager());
        ActionGenerator.init(jda());
        ConverterGenerator.init(jda());
        
        commandInputManager(); //커맨드 인풋을 받기 위해 수행한다
        
        jda().addEventListener(reactEventRepeater());
        jda().addEventListener(chatEventRepeater());
        jda().addEventListener(joinQuitEventRepeater());
    }

    public static CommandInputManager getCommandInputManager() {
        if(isUsed)
            return commandInputManager();
        else throw new UnusedConfigurationException("Cacophony Vanilla");
    }
    private static CommandInputManager commandInputManager() {
        if(commandInputManager == null) {
            commandInputManager = new CommandInputManager(commandManager(), jda());
        }
        return commandInputManager;
    }

    public static CommandManager getCommandManager() {
        if(isUsed)
            return getCommandManager();
        else throw new UnusedConfigurationException("Cacophony Vanilla");
    }
    private static CommandManager commandManager() {
        if(commandManager == null) {
            commandManager = new CommandManager();
        }
        return commandManager;
    }

    public static JDA getJda() {
        if(isUsed)
            return jda();
        else throw new UnusedConfigurationException("Cacophony Vanilla");
    }
    private static JDA jda() {
        if(jda == null) {
            try {
                jda = JDABuilder.createDefault(token)
                        .enableIntents(GatewayIntent.GUILD_MEMBERS)
                        .build();
            } catch (LoginException e) {
                throw new BotCreationFailureException(e);
            }
        }
        return jda;
    }

    private static ListenerCaller listenerCaller() {
        if(listenerCaller == null) {
            listenerCaller = new ListenerCaller();
        }
        return listenerCaller;
    }

    private static ReactEventRepeater reactEventRepeater() {
        if(reactEventRepeater == null) {
            reactEventRepeater = new ReactEventRepeater(listenerCaller());
        }
        return reactEventRepeater;
    }

    private static ChatEventRepeater chatEventRepeater() {
        if(chatEventRepeater == null) {
            chatEventRepeater = new ChatEventRepeater(listenerCaller());
        }
        return chatEventRepeater;
    }

    private static JoinQuitEventRepeater joinQuitEventRepeater() {
        if(joinQuitEventRepeater == null) {
            joinQuitEventRepeater = new JoinQuitEventRepeater(listenerCaller());
        }
        return joinQuitEventRepeater;
    }
}

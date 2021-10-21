package io.github.key_del_jeeinho.cacophony_lib.global.config;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater.ChatEventRepeater;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater.JoinQuitEventRepeater;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater.ReactEventRepeater;
import io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowBuilderGenerator;
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

    public static void start(String token) {
        isUsed = true;
        FlowBuilderGenerator.init(listenerCaller());
        CacophonyVanilla.token = token;
        jda().addEventListener(reactEventRepeater());
        jda().addEventListener(chatEventRepeater());
        jda().addEventListener(joinQuitEventRepeater());
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
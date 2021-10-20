package config;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.repeater.JoinQuitEventRepeater;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.global.exception.BotCreationFailureException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

/**
 * 테스트용 Configuration 입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class CacophonyConfiguration {
    private static ListenerCaller listenerCaller;
    private static JoinQuitEventRepeater joinQuitEventRepeater;
    private static JDA jda;

    public static JDA jda() {
        try {
            String token = "";
            if (jda == null) jda = JDABuilder.createDefault(token).build();
            return jda;
        } catch(LoginException e) {
            throw new BotCreationFailureException(e);
        }
    }

    public static ListenerCaller listenerCaller() {
        if(listenerCaller == null) listenerCaller = new ListenerCaller();
        return listenerCaller;
    }

    public static JoinQuitEventRepeater eventRepeater() {
        if(joinQuitEventRepeater == null) joinQuitEventRepeater = new JoinQuitEventRepeater(listenerCaller());
        return joinQuitEventRepeater;
    }
}

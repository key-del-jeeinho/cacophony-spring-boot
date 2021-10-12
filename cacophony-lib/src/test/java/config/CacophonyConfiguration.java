package config;

import com.velocia.cacophony.domain.event.EventRepeater;
import com.velocia.cacophony.domain.event.ListenerCaller;
import com.velocia.cacophony.global.exception.BotCreationFailureException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class CacophonyConfiguration {
    private static ListenerCaller listenerCaller;
    private static EventRepeater eventRepeater;
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

    public static EventRepeater eventRepeater() {
        if(eventRepeater == null) eventRepeater = new EventRepeater(listenerCaller());
        return eventRepeater;
    }
}

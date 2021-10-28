package io.github.key_del_jeeinho.cacophony_example.welcome;

import io.github.key_del_jeeinho.cacophony_example.CacophonySpringBootApplication;
import io.github.key_del_jeeinho.cacophony_lib.autoconfigure.UseCacophony;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.JoinEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.listeners.EventListener;
import net.dv8tion.jda.api.JDA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Objects;

import static io.github.key_del_jeeinho.cacophony_lib.domain.action.ActionEntry.chat;
import static io.github.key_del_jeeinho.cacophony_lib.domain.converter.ConverterEntry.userToDM;
import static io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowEntry.when;
import static io.github.key_del_jeeinho.cacophony_lib.domain.entry.EntryEntry.onJoin;

@SpringBootApplication
@UseCacophony
public class WelcomeBot {
    public static void main(String[] args) {
        SpringApplication.run(CacophonySpringBootApplication.class, args);

        when(onJoin()).doAction(//FlowBuilder 의 Method 입니다. Action Block 을 설정합니다
                (EventListener<JoinEvent>) event -> //JoinEvent 형식으로 event 를 받아, 동작하는 action 임을 명시합니다
                    chat("서버에 가입하신것을 환영합니다!", userToDM(event.getJoiner().getId()).getId())
        ).complete(); //Flow를 Build 하고 Cacophony 에 등록합니다
    }
}

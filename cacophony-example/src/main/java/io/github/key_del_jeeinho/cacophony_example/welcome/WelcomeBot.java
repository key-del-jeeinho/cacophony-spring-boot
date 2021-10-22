package io.github.key_del_jeeinho.cacophony_example.welcome;

import io.github.key_del_jeeinho.cacophony_example.CacophonySpringBootApplication;
import io.github.key_del_jeeinho.cacophony_lib.autoconfigure.UseCacophony;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.JoinEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.listeners.EventListener;
import net.dv8tion.jda.api.JDA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowEntry.when;
import static io.github.key_del_jeeinho.cacophony_lib.domain.trigger.TriggerEntry.onJoin;

@SpringBootApplication
@UseCacophony
@Component
public class WelcomeBot {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CacophonySpringBootApplication.class, args); //Main method 에서 Bean 을 Injection 하기위해 Context를 저장합니다

        JDA jda = context.getBean(JDA.class); //Cacophony 에서 자동으로 등록해준 JDA Bean 을 탐색해서 가져옵니다.

        when(//FlowBuilder 의 EntryPoint 입니다. Entry Block 을 설정합니다
                onJoin()//만약 신규 유저가 서버에 들어왔을경우
        ).doSomething(//FlowBuilder 의 Method 입니다. Action Block 을 설정합니다
                (EventListener<JoinEvent>) event -> {//JoinEvent 형식으로 event 를 받아, 동작하는 action 임을 명시합니다
                    long userId = event.getJoiner().getId();;//해당 채팅이 쳐진 채널의 id(snowflake) 를 구합니다
                    //JDA 를 통해 이전에 구한 채널 채널ID 를 가지고 channel 을 불러옵니다
                    // 이후, pong 이라는 채팅을 보냅니다.
                    Objects.requireNonNull(jda.retrieveUserById(userId)).complete()
                            .openPrivateChannel().complete()
                            .sendMessage("서버에 가입하신것을 환영합니다!").complete();
                }
        ).complete(); //Flow를 Build 하고 Cacophony 에 등록합니다
    }
}

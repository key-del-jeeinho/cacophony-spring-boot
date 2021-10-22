package io.github.key_del_jeeinho.cacophony_example.pingpong;

import io.github.key_del_jeeinho.cacophony_example.CacophonySpringBootApplication;
import io.github.key_del_jeeinho.cacophony_lib.autoconfigure.UseCacophony;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.listeners.EventListener;
import net.dv8tion.jda.api.JDA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowEntry.when;
import static io.github.key_del_jeeinho.cacophony_lib.domain.trigger.TriggerEntry.onChat;

@SpringBootApplication
@UseCacophony
@Component
public class PingPongBot {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CacophonySpringBootApplication.class, args); //Main method 에서 Bean 을 Injection 하기위해 Context를 저장합니다

        JDA jda = context.getBean(JDA.class); //Cacophony 에서 자동으로 등록해준 JDA Bean 을 탐색해서 가져옵니다.

        when(//FlowBuil 의 EntryPoint 입니다. Entry Block 을 설정합니다
                onChat()//만약 채팅을 쳤을 경우
        ).doSomething(//FlowBuilder 의 Method 입니다. Action Block 을 설정합니다
                (EventListener<ChatEvent>) event -> {//ChatEvent 형식으로 event 를 받아, 동작하는 action 임을 명시합니다
                    if(event.getEventType() != ChatEvent.EventType.WRITE) return;//만약 채팅이 작성된것이 아닐 경우(ex, 삭제/수정 등) 동작을 종료합니다
                    if(event.getMessage().getContent().equals("ping")) {//만약 "ping" 이라고 채팅을 쳤을 경우
                        long channelId = event.getChannel().getId();//해당 채팅이 쳐진 채널의 id(snowflake) 를 구합니다
                        //JDA 를 통해 이전에 구한 채널 채널ID 를 가지고 channel 을 불러옵니다
                        // 이후, pong 이라는 채팅을 보냅니다.
                        Objects.requireNonNull(jda.getTextChannelById(channelId)).sendMessage("pong").complete();
                    }
                }
        ).complete(); //Flow를 Build 하고 Cacophony 에 등록합니다
    }
}
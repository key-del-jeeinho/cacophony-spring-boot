package io.github.key_del_jeeinho.cacophony_example;

import io.github.key_del_jeeinho.cacophony_lib.autoconfigure.UseCacophony;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.listeners.EventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowEntry.when;
import static io.github.key_del_jeeinho.cacophony_lib.domain.trigger.TriggerEntry.*;

@SpringBootApplication
@UseCacophony
public class CacophonySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacophonySpringBootApplication.class, args);

        when(
                onDM().and().onJoin()
        ).doAction(
                event -> System.out.println(event.getClass().getSimpleName() + " 가 발생하였습니다!")
        ).complete();

        when(
                onChat().and().onReact()
        ).doAction(
                (EventListener<ChatEvent>) event -> System.out.println(event.getMessage())
        ).complete();

        when(
                onReact()
        ).doAction(
                (EventListener<ReactEvent>) event -> System.out.println("타입 : " + event.getEventType() + "이모지 : " + event.getEmote())
        ).complete();
    }
}

package com.velocia.cacophony.example;

import com.velocia.cacophony.autoconfigure.prop.CacophonyProperties;
import com.velocia.cacophony.autoconfigure.UseCacophony;
import com.velocia.cacophony.domain.event.events.ChatEvent;
import com.velocia.cacophony.domain.listener.EventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import static com.velocia.cacophony.domain.flow.FlowEntry.when;
import static com.velocia.cacophony.domain.trigger.TriggerEntry.onChat;
import static com.velocia.cacophony.domain.trigger.TriggerEntry.onJoin;

@SpringBootApplication
@UseCacophony
@EnableConfigurationProperties(CacophonyProperties.class)
public class CacophonyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacophonyApplication.class, args);

        when(
                onChat().and().onJoin()
        ).doSomething(
                event -> System.out.println(event.getClass().getSimpleName() + " 가 발생하였습니다!")
        ).complete();
        when(
                onJoin()
        ).doSomething(
                (EventListener<ChatEvent>) event -> System.out.println(event.getMessage().getJumpUrl())
        ).complete();
    }
}

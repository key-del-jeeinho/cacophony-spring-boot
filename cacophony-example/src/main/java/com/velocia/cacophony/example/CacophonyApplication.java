package com.velocia.cacophony.example;

import com.velocia.cacophony.autoconfigure.CacophonyAutoConfiguration;
import com.velocia.cacophony.autoconfigure.CacophonyProperties;
import com.velocia.cacophony.domain.event.ListenerCaller;
import com.velocia.cacophony.domain.event.events.ChatEvent;
import net.dv8tion.jda.api.JDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import static com.velocia.cacophony.domain.flow.FlowEntry.when;
import static com.velocia.cacophony.domain.trigger.TriggerEntry.onChat;

@SpringBootApplication
@Import(CacophonyAutoConfiguration.class)
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
                onChat()
        ).doSomething(
                event -> System.out.println("chat is | " + ((ChatEvent)event).getMessage().getMessage())
        ).complete();
        while(true);
    }
}

package io.github.key_del_jeeinho.cacophony_example;

import io.github.key_del_jeeinho.cacophony_lib.autoconfigure.prop.CacophonyProperties;
import io.github.key_del_jeeinho.cacophony_lib.autoconfigure.UseCacophony;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import static io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowEntry.when;
import static io.github.key_del_jeeinho.cacophony_lib.domain.trigger.TriggerEntry.onChat;

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
        /*
        when(
                onChat().and().onReact()
        ).doSomething(
                (EventListener<ChatEvent>) event -> System.out.println(event.getMessage().getJumpUrl())
        ).complete();

         */
    }
}

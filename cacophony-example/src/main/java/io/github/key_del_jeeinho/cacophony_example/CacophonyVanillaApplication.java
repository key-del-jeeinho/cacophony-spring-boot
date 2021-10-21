package io.github.key_del_jeeinho.cacophony_example;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.CommandAction;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.listeners.EventListener;
import io.github.key_del_jeeinho.cacophony_lib.global.config.CacophonyVanilla;

import static io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowEntry.when;
import static io.github.key_del_jeeinho.cacophony_lib.domain.trigger.TriggerEntry.*;
import static io.github.key_del_jeeinho.cacophony_lib.domain.command.CommandEntry.*;

public class CacophonyVanillaApplication {
    public static void main(String[] args) {
        CacophonyVanilla.start("TOKEN");
        when(
                onDM().and().onJoin()
        ).doSomething(
                event -> System.out.println(event.getClass().getSimpleName() + " 가 발생하였습니다!")
        ).complete();

        when(
                onChat().and().onReact()
        ).doSomething(
                (EventListener<ChatEvent>) event -> System.out.println(event.getMessage())
        ).complete();

        when(
                onReact()
        ).doSomething(
                (EventListener<ReactEvent>) event -> System.out.println("타입 : " + event.getEventType() + "이모지 : " + event.getEmote())
        ).complete();

        root("소고야",
                command("인증",
                        action((CommandAction) System.out::println),
                        action((CommandAction) System.out::println)
                ),

                command("도움말", action(() -> System.out.println("도움말입니다"))),

                command("투표",
                        command("열기",
                                action((CommandAction) System.out::println),
                                action((CommandAction) System.out::println)
                                ),
                        action((CommandAction)System.out::println)
                        )
        ).complete();
    }
}

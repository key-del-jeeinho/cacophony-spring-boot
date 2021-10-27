package io.github.key_del_jeeinho.cacophony_example;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.chat.ChatEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.events.react.ReactEvent;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.listeners.EventListener;
import io.github.key_del_jeeinho.cacophony_lib.global.config.CacophonyVanilla;

import static io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowEntry.when;
import static io.github.key_del_jeeinho.cacophony_lib.domain.entry.EntryEntry.*;
import static io.github.key_del_jeeinho.cacophony_lib.domain.command.CommandEntry.*;

public class CacophonyVanillaApplication {
    public static void main(String[] args) {
        CacophonyVanilla.start("ODk3MTI3NDc5OTIyMjc4NDYx.YWRJEw.b8qBeezI9EWCl49Tn2FJ76KsbJg");
        when(
                onDM().and().onJoin()
        ).doAction(
                event -> System.out.println(event.getClass().getSimpleName() + " 가 발생하였습니다!")
        ).complete();

        when(
                onChat().and().onReact()
        ).doAction(
                (EventListener<ChatEvent>) event -> System.out.println(event.getMessage())
        );//.complete();

        when(
                onReact()
        ).doAction(
                (EventListener<ReactEvent>) event -> System.out.println("타입 : " + event.getEventType() + "이모지 : " + event.getEmote())
        ).complete();

        root("소고야",
                command("인증",
                        action(argument -> System.out.println(argument.getArgument()))
                ),

                command("도움말", action(() -> System.out.println("도움말입니다"))),

                command("투표",
                        action(() -> System.out.println("투표를 진행합니다!")),
                        command("열기", System.out::println))
        ).complete();
    }
}

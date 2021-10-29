package io.github.key_del_jeeinho.cacophony_example.calculator;

import io.github.key_del_jeeinho.cacophony_example.CacophonySpringBootApplication;
import io.github.key_del_jeeinho.cacophony_lib.autoconfigure.UseCacophony;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.component.Argument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.BiFunction;

import static io.github.key_del_jeeinho.cacophony_lib.domain.action.ActionEntry.chat;
import static io.github.key_del_jeeinho.cacophony_lib.domain.command.CommandEntry.*;
import static io.github.key_del_jeeinho.cacophony_lib.domain.command.CommandEntry.command;

@SpringBootApplication
@UseCacophony
public class CalculatorCommandBot {
    public static int operate(Argument argument, BiFunction<Integer, Integer, Integer> operator) {
        int a = Integer.parseInt(argument.getArgument());
        int b = Integer.parseInt(argument.getNext().getArgument());

        return operator.apply(a, b);
    }

    public static void main(String[] args) {
        SpringApplication.run(CacophonySpringBootApplication.class, args);

        root("계산기",
                command("더하기",
                        action((argument, author, channel) -> {
                            if(argument == null || argument.getNext() == null) return;
                            chat("결과 : " + operate(argument, Integer::sum), channel.getId());
                        })
                ),
                command("빼기",
                        action((argument, author, channel) -> {
                            if(argument == null || argument.getNext() == null) return;
                            chat("결과 : " + operate(argument, (a, b) -> a - b), channel.getId());
                        })
                ),
                command("곱하기",
                        action((argument, author, channel) -> {
                            if(argument == null || argument.getNext() == null) return;
                            chat("결과 : " + operate(argument, (a, b) -> a * b), channel.getId());
                        })
                ),
                command("나누기",
                        action((argument, author, channel) -> {
                            if(argument == null || argument.getNext() == null) return;
                            if(Integer.parseInt(argument.getNext().getArgument()) != 0)
                                chat("결과 : " + operate(argument, (a, b) -> a / b), channel.getId());
                            else chat("나눗셈의 제수는 0이 될 수 없습니다!", channel.getId());
                        })
                )
        ).complete();
    }
}

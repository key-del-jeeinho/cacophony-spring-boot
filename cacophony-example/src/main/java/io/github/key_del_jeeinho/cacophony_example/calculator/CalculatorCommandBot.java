package io.github.key_del_jeeinho.cacophony_example.calculator;

import io.github.key_del_jeeinho.cacophony_example.CacophonySpringBootApplication;
import io.github.key_del_jeeinho.cacophony_lib.autoconfigure.UseCacophony;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static io.github.key_del_jeeinho.cacophony_lib.domain.command.CommandEntry.*;
import static io.github.key_del_jeeinho.cacophony_lib.domain.command.CommandEntry.command;

@SpringBootApplication
@UseCacophony
public class CalculatorCommandBot {
    public static void main(String[] args) {
        SpringApplication.run(CacophonySpringBootApplication.class, args);

        root("계산기",
                command("더하기",
                        action(argument -> {
                            if(argument == null || argument.getNext() == null) return;
                            int a = Integer.parseInt(argument.getArgument());
                            int b = Integer.parseInt(argument.getNext().getArgument());
                            System.out.println(a + b);
                        }) //만약 인증 다음 인자가 없을시 argument 가 null 이므로 NPE 발생
                ),
                command("빼기",
                        action(argument -> {
                            if(argument == null || argument.getNext() == null) return;
                            int a = Integer.parseInt(argument.getArgument());
                            int b = Integer.parseInt(argument.getNext().getArgument());
                            System.out.println(a - b);
                        }) //만약 인증 다음 인자가 없을시 argument 가 null 이므로 NPE 발생 //만약 인증 다음 인자가 없을시 argument 가 null 이므로 NPE 발생
                ),
                command("곱하기",
                        action(argument -> {
                            if(argument == null || argument.getNext() == null) return;
                            int a = Integer.parseInt(argument.getArgument());
                            int b = Integer.parseInt(argument.getNext().getArgument());
                            System.out.println(a * b);
                        }) //만약 인증 다음 인자가 없을시 argument 가 null 이므로 NPE 발생//만약 인증 다음 인자가 없을시 argument 가 null 이므로 NPE 발생
                ),
                command("나누기",
                        action(argument -> {
                            if(argument == null || argument.getNext() == null) return;
                            int a = Integer.parseInt(argument.getArgument());
                            int b = Integer.parseInt(argument.getNext().getArgument());
                            if(b != 0)
                            System.out.println(a / b);
                            else System.out.println("나눗셈의 제수는 0이 될 수 없습니다!");
                        }) //만약 인증 다음 인자가 없을시 argument 가 null 이므로 NPE 발생//만약 인증 다음 인자가 없을시 argument 가 null 이므로 NPE 발생
                )
        ).complete();
    }
}

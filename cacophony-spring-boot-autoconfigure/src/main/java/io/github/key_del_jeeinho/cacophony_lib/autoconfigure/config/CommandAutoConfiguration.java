package io.github.key_del_jeeinho.cacophony_lib.autoconfigure.config;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandInputManager;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandManager;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@RequiredArgsConstructor
@DependsOn({"jda"})
public class CommandAutoConfiguration {
    private final JDA jda;

    private static CommandManager commandManager;

    @Bean
    public CommandManager commandManager() {
        if(commandManager == null) commandManager = new CommandManager();
        return commandManager;
    }

    @Bean
    public CommandInputManager commandInputManager() {
        return new CommandInputManager(commandManager(), jda);
    }
}

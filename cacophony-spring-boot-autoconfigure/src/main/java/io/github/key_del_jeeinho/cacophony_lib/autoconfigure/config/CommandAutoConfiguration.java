package io.github.key_del_jeeinho.cacophony_lib.autoconfigure.config;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandInputManager;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommandAutoConfiguration {
    private static CommandManager commandManager;

    @Bean
    public CommandManager commandManager() {
        if(commandManager == null) commandManager = new CommandManager();
        return commandManager;
    }

    @Bean
    public CommandInputManager commandInputManager() {
        return new CommandInputManager(commandManager());
    }
}

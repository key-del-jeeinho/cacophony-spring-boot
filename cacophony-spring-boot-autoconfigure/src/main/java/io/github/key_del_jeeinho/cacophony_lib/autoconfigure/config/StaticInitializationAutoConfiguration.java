package io.github.key_del_jeeinho.cacophony_lib.autoconfigure.config;

import io.github.key_del_jeeinho.cacophony_lib.domain.action.ActionGenerator;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.RootCommandGenerator;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandManager;
import io.github.key_del_jeeinho.cacophony_lib.domain.converter.ConverterGenerator;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowGenerator;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * StaticClass 들의 구성정보를 초기화하기 위한 Configuration입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@DependsOn({"jda", "listenerCaller", "commandManager"})
public class StaticInitializationAutoConfiguration {
    public StaticInitializationAutoConfiguration(CommandManager commandManager, ListenerCaller listenerCaller, JDA jda) {
        FlowGenerator.init((listenerCaller));
        ActionGenerator.init(jda);
        RootCommandGenerator.init(commandManager);
        ConverterGenerator.init(jda);
    }
}

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

/**
 * StaticClass 들의 구성정보를 초기화하기 위한 Configuration입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@RequiredArgsConstructor
public class StaticInitializationAutoConfiguration {
    private final CommandManager commandManager;
    private final ListenerCaller listenerCaller;
    private final JDA jda;

    @Bean
    public FlowGenerator flowBuilderGenerator() {
        FlowGenerator.init((listenerCaller));
        return new FlowGenerator();
    }

    @Bean
    public ActionGenerator actionBuilderGenerator() {
        ActionGenerator.init(jda);
        return new ActionGenerator();
    }

    @Bean
    public RootCommandGenerator rootCommandBuilderGenerator() {
        RootCommandGenerator.init(commandManager);
        return new RootCommandGenerator();
    }

    @Bean
    public ConverterGenerator converterGenerator() {
        ConverterGenerator.init(jda);
        return new ConverterGenerator();
    }
}

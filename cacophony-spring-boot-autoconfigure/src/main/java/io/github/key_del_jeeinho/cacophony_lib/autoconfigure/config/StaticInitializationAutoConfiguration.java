package io.github.key_del_jeeinho.cacophony_lib.autoconfigure.config;

import io.github.key_del_jeeinho.cacophony_lib.domain.action.ActionBuilderGenerator;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.RootCommandBuilderGenerator;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.manager.CommandManager;
import io.github.key_del_jeeinho.cacophony_lib.domain.event.ListenerCaller;
import io.github.key_del_jeeinho.cacophony_lib.domain.flow.FlowBuilderGenerator;
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
    public FlowBuilderGenerator flowBuilderGenerator() {
        FlowBuilderGenerator.init((listenerCaller));
        return new FlowBuilderGenerator();
    }

    @Bean
    public ActionBuilderGenerator actionBuilderGenerator() {
        ActionBuilderGenerator.init(jda);
        return new ActionBuilderGenerator();
    }

    @Bean
    public RootCommandBuilderGenerator rootCommandBuilderGenerator() {
        RootCommandBuilderGenerator.init(commandManager);
        return new RootCommandBuilderGenerator();
    }
}

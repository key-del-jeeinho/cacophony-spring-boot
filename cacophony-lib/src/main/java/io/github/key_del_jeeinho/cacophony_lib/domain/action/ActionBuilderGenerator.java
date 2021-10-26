package io.github.key_del_jeeinho.cacophony_lib.domain.action;

import net.dv8tion.jda.api.JDA;

public class ActionBuilderGenerator {
    private static JDA jda;

    public static ActionBuilder generateDefault() {
        return new ActionBuilder(jda);
    }

    public static void init(JDA jda) {
        ActionBuilderGenerator.jda = jda;
    }
}

package io.github.key_del_jeeinho.cacophony_lib.domain.action;

import net.dv8tion.jda.api.JDA;

public class ActionGenerator {
    private static JDA jda;

    public static Action generateDefault() {
        return new Action(jda);
    }

    public static void init(JDA jda) {
        ActionGenerator.jda = jda;
    }
}

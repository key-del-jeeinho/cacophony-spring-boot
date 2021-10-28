package io.github.key_del_jeeinho.cacophony_lib.domain.converter;

import net.dv8tion.jda.api.JDA;

public class ConverterGenerator {
    private static JDA jda;

    public static Converter generateDefault() {
        return new Converter(jda);
    }

    public static void init(JDA jda) {
        ConverterGenerator.jda = jda;
    }
}

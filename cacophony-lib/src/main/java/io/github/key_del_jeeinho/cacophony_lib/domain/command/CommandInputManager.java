package io.github.key_del_jeeinho.cacophony_lib.domain.command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandInputManager {
    public VArgument input(String input) {
        VArgument vArg = null;
        String[] reversedInputArgs = reverse(input.split(" ")); //leaf 먼저 설정하기위해 args 의 순서를 뒤집는다
        for (String arg : reversedInputArgs) {
            if(vArg == null)
                vArg = new VArgument(arg);
            else vArg = new VArgument(arg, vArg);
        }
        return vArg;
    }

    private String[] reverse(String[] orign) {
        String[] argsArr = orign;
        List<String> args = Arrays.asList(argsArr);
        Collections.reverse(args);
        return args.toArray(argsArr);
    }
}

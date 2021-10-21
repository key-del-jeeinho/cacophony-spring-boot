package io.github.key_del_jeeinho.cacophony_lib.domain.command;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VArgument {
    private final List<Consumer<VArgument>> doWhat; //해당 인자값으로 무엇을 할것인지
    @Getter
    private final VArgument next;
    @Getter
    private final String argument; //실제 사용자가 입력한 인자값
    @Getter
    private final boolean isLeaf;
    private int depth;

    private VArgument(String argument, VArgument next, boolean isLeaf) {
        this.doWhat = new ArrayList<>();
        this.next = next;
        this.argument = argument;
        this.isLeaf = isLeaf;
    }

    public VArgument(String argument, VArgument next) {
        this(argument, next, argument == null);
    }

    public VArgument(String argument) {
        this(argument, null);
    }

    public static void initDepth(VArgument root) {
        root.initDepth(0);
    }
    private void initDepth(int parentDepth) {
        depth = parentDepth;
        if(!isLeaf)
            next.initDepth(parentDepth+1);
    }
}

package io.github.key_del_jeeinho.cacophony_lib.domain.command.component;

import lombok.Getter;

public class Argument {
    @Getter
    private final Argument next;
    @Getter
    private final String argument; //실제 사용자가 입력한 인자값
    @Getter
    private final boolean isLeaf;
    private int depth;

    //Constructors
    private Argument(String argument, Argument next, boolean isLeaf) {
        this.next = next;
        this.argument = argument;
        this.isLeaf = isLeaf;
    }
    public Argument(String argument, Argument next) {
        //next argument 가 null 일경우, 해당 VArgument 가 leaf argument 이다.
        this(argument, next, argument == null);
    }
    public Argument(String argument) {
        this(argument, null);
    }

    //Setting Argument's depth
    public static void initDepth(Argument root) {
        root.initDepth(0);
    }
    public void initDepth() {
        initDepth(this);
    }
    private void initDepth(int parentDepth) {
        depth = parentDepth;
        if(!isLeaf)
            next.initDepth(parentDepth+1);
    }
}

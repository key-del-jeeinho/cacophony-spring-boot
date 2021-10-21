package domain.command;

import io.github.key_del_jeeinho.cacophony_lib.domain.command.CommandInputManager;
import io.github.key_del_jeeinho.cacophony_lib.domain.command.VArgument;
import org.junit.jupiter.api.Test;

public class CommandInputManagerTest {
    CommandInputManager inputManager = new CommandInputManager();

    @Test
    public void testInput() {
        String input = "포니야1 봇2 생성3 SogoBot4 테스트봇입니다5";
        VArgument vArg = inputManager.input(input);
        System.out.println(vArg.getArgument());
        System.out.println(vArg.getNext().getArgument());
        System.out.println(vArg.getNext().getNext().getArgument());
        System.out.println(vArg.getNext().getNext().getNext().getArgument());
        System.out.println(vArg.getNext().getNext().getNext().getNext().getArgument());
    }
}

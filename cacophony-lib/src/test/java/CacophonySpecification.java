import com.velocia.cacophony.domain.config.CacophonyConfiguration;
import org.junit.jupiter.api.Test;

import static com.velocia.cacophony.domain.flow.FlowEntry.when;
import static com.velocia.cacophony.domain.trigger.TriggerEntry.onChat;

public class CacophonySpecification {
    @Test
    public void specification001() {
        when(
                onChat().and().onJoin()
        ).doSomething(
                event -> System.out.println(event.getClass().getSimpleName() + " 가 발생하였습니다!")
        ).complete();
        when(
                onChat()
        ).doSomething(
                event -> System.out.println(event.getClass().getSimpleName() + "is occured!")
        ).complete();
        CacophonyConfiguration.eventRepeater().onGuildMessageReceived(null);
    }
}

import com.velocia.cacophony.domain.config.CacophonyConfiguration;
import com.velocia.cacophony.domain.flow.FlowEntry;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.velocia.cacophony.domain.flow.FlowEntry.when;
import static com.velocia.cacophony.domain.trigger.TriggerEntry.onChat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

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

        GuildMessageReceivedEvent event = mock(GuildMessageReceivedEvent.class);
        Message message = mock(Message.class);
        Mockito.when(message.getContentRaw()).thenReturn("테스트 채팅 입니다!");
        Mockito.when(event.getMessage()).thenReturn(message);

        CacophonyConfiguration.eventRepeater().onGuildMessageReceived(event);
        CacophonyConfiguration.eventRepeater().onGuildJoin(mock(GuildJoinEvent.class));
    }
}

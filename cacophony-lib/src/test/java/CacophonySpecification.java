import static org.mockito.Mockito.mock;

/**
 * Cacophony API 에 대한 스펙 명세서 입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class CacophonySpecification {

    /*
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
                (EventListener<ChatEvent>) event ->  System.out.println("chat is | " + event.getMessage())
        ).complete();

        Message message = mock(Message.class);
        Mockito.when(message.getContentRaw()).thenReturn("테스트 채팅 입니다!");

        GuildMessageReceivedEvent event = mock(GuildMessageReceivedEvent.class);
        Mockito.when(event.getMessage()).thenReturn(message);

        CacophonyConfiguration.eventRepeater().onGuildMessageReceived(event);
        CacophonyConfiguration.eventRepeater().onGuildJoin(mock(GuildJoinEvent.class));
    }

     */
}

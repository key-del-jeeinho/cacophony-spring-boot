package com.velocia.cacophony.domain.entry_point;

import org.junit.jupiter.api.Test;

import static com.velocia.cacophony.domain.entry_point.entry.EventEntry.onChat;
import static com.velocia.cacophony.domain.entry_point.entry.TimeConditionEntry.before;
import static com.velocia.cacophony.domain.entry_point.entry.DoEntry.doSomething;

public class DoEntryTest {
    @Test
    public void specificationDoEntry() {
        doSomething(event -> System.out.println("채팅 입력이 감지되었습니다!\n감지된 이벤트 : " + event.getClass().getSimpleName()))
                .when(
                        before(onChat())
                        .and().after(onChat())
                ).ifThrows(Exception.class, exception -> System.out.println("exception 이 발생하였습니다!"))
                .complete();
    }
}

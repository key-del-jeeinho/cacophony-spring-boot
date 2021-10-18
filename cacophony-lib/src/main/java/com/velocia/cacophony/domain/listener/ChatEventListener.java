package com.velocia.cacophony.domain.listener;

import com.velocia.cacophony.domain.event.events.ChatEvent;

/**
 * ChatEvent에 대한 처리를 담는 FunctionalInterface 입니다.
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class ChatEventListener implements EventListener<ChatEvent> {
    @Override
    public void call(ChatEvent event) {

    }

    public String getName() {
        return "ChatEventListener";
    }
}

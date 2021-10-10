package com.velocia.cacophony.domain.listener;

import com.velocia.cacophony.domain.event.events.ChatEvent;

public class ChatEventListener implements EventListener<ChatEvent> {
    @Override
    public void call(ChatEvent event) {

    }

    public String getName() {
        return "ChatEventListener";
    }
}

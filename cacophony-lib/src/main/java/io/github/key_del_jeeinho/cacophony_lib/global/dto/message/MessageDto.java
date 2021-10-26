package io.github.key_del_jeeinho.cacophony_lib.global.dto.message;

import io.github.key_del_jeeinho.cacophony_lib.global.dto.DiscordData;
import lombok.Getter;

@Getter
public class MessageDto extends DiscordData {
    private final String content;

    public MessageDto(long id, String content) {
        super(id);
        this.content = content;
    }
}

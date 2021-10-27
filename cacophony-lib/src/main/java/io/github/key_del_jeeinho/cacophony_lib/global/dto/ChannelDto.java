package io.github.key_del_jeeinho.cacophony_lib.global.dto;

import io.github.key_del_jeeinho.cacophony_lib.domain.event.enum_type.ChannelType;
import lombok.Getter;

/**
 * 디스코드 에서 서버에 존재하는 채널에 대한 정보를 저장하는 Dto 입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
@Getter
public class ChannelDto extends DiscordData {
    private final ChannelType type;
    private final String name;

    public ChannelDto(long id, String name, ChannelType type) {
        super(id);
        this.type = type;
        this.name = name;
    }
}

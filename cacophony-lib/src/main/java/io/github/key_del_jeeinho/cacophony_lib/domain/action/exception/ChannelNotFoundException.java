package io.github.key_del_jeeinho.cacophony_lib.domain.action.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ChannelNotFoundException extends RuntimeException {
    private final long channelId;
}

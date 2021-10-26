package io.github.key_del_jeeinho.cacophony_lib.domain.action.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ServerNotFoundException extends RuntimeException {
    private final long serverId;
}

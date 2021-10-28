package io.github.key_del_jeeinho.cacophony_lib.global.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleNotFoundException extends RuntimeException {
    private final Long roleId;
}

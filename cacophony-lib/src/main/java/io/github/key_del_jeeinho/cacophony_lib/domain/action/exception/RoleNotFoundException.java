package io.github.key_del_jeeinho.cacophony_lib.domain.action.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleNotFoundException extends RuntimeException {
    private final Long roleId;
}

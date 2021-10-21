package io.github.key_del_jeeinho.cacophony_lib.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UnusedConfigurationException extends RuntimeException {
    private final String configName;
}

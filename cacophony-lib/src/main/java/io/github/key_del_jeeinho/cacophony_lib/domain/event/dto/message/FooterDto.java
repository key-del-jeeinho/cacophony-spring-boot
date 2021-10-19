package io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class FooterDto {
    private final String text;
    private String iconUrl;
}

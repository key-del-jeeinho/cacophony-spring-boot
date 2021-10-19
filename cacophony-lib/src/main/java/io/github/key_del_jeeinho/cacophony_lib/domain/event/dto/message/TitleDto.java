package io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class TitleDto {
    private final String title;
    private String url;
}

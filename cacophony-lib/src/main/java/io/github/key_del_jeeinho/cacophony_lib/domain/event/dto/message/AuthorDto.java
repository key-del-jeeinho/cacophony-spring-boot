package io.github.key_del_jeeinho.cacophony_lib.domain.event.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class AuthorDto {
    private final String name;
    private String url;
    private String iconUrl;
}

package com.velocia.cacophony.domain.event.dto.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SectionDto {
    private final String title;
    private final String text;
    private final Boolean inline;
}

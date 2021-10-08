package com.velocia.cacophony.domain.condition.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RelativeTimeNotFoundException extends RuntimeException {
    private final Integer id;
}

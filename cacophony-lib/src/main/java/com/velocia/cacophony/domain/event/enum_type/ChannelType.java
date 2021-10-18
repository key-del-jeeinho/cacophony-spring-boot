package com.velocia.cacophony.domain.event.enum_type;

import com.velocia.cacophony.domain.event.exception.ChannelTypeNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
public enum ChannelType {
    SERVER(0), PRIVATE(1);

    private final int id;
    public static ChannelType of(net.dv8tion.jda.api.entities.ChannelType type) {
        Optional<ChannelType> result = Arrays.stream(values()).filter(element -> element.id == type.getId())
                .findFirst();

        if(result.isEmpty()) throw new ChannelTypeNotFoundException();
        return result.get();
    }
}

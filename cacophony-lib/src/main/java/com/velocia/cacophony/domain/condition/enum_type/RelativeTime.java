package com.velocia.cacophony.domain.condition.enum_type;

import com.velocia.cacophony.domain.condition.exception.RelativeTimeNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
public enum RelativeTime {
    //Single
    BEFORE(2), AFTER_RETURNING(3), AFTER_THROW(5),
    //Double
    AFTER(AFTER_RETURNING.id * AFTER_THROW.id),
    BEFORE_AND_AFTER_RETURNING(BEFORE.id * AFTER_RETURNING.id),
    BEFORE_AND_AFTER_THROW(BEFORE.id * AFTER_THROW.id),
    //Triple
    AROUND(BEFORE.id * AFTER.id);

    @Getter
    private final int id;

    public RelativeTime add(RelativeTime relativeTime) {
        //Double 이상의 상대시간이 Single 상대시간의 곱으로 이루어져있는점을 활용해서
        // 자신의 id 가 인자로받은 상대시간의 id 를 약수로 가지는지 확인한다
        if(id % relativeTime.id == 0) //이미 해당 상대시간을 포함하고 있을경우
            return this;
        else return RelativeTime.of(id * relativeTime.id);
    }

    private static RelativeTime of(int id) {
        Optional<RelativeTime> time =  Arrays.stream(values())
                .filter(relativeTime -> relativeTime.id == id)
                .findFirst();
        if(time.isEmpty()) throw new RelativeTimeNotFoundException(id);
        return time.get();
    }
}

package com.pinsoft.challenge.domain.aggregate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MinesweeperAggregate {

    private String[] hints;
}

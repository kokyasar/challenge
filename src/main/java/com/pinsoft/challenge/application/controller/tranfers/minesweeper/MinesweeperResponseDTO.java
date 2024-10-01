package com.pinsoft.challenge.application.controller.tranfers.minesweeper;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MinesweeperResponseDTO {

    private String[] hints;
}

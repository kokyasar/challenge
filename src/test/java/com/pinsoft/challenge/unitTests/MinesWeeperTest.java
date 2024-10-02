package com.pinsoft.challenge.unitTests;

import com.pinsoft.challenge.domain.aggregate.MinesweeperAggregate;
import com.pinsoft.challenge.domain.aggregate.RpnCalculatorAggregate;
import com.pinsoft.challenge.domain.usecase.MinesweeperUseCase;
import com.pinsoft.challenge.domain.usecase.RpnCalculatorUseCase;
import com.pinsoft.challenge.domain.usecasehandler.MinesweeperUseCaseHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MinesWeeperTest {

    private static final String[] SQUARE_1 = {"**...",".....",".*..."};
    private static final String[] HINTS_1 = {"**100","33200","1*100"};
    private static final String[] SQUARE_2 = {"*...","....",".*..","...."};
    private static final String[] HINTS_2 = {"*100","2210",".1*10","1110"};
    MinesweeperUseCaseHandler handler;

    @BeforeEach
    public void setup() {
        handler = new MinesweeperUseCaseHandler();
    }

    @Test
    @DisplayName("show hints successfully for square 1")
    void rpn_calculated_successfully_for_square_1(){

        MinesweeperUseCase useCase = buildUseCase(SQUARE_1);

        MinesweeperAggregate aggregate = buildAggregate(HINTS_1);

        Assertions.assertEquals(Arrays.stream(aggregate.getHints()).findFirst(), Arrays.stream(handler.handle(useCase).getHints()).findFirst());
    }

    @Test
    @DisplayName("show hints successfully for square 2")
    void rpn_calculated_successfully_for_square_2(){

        MinesweeperUseCase useCase = buildUseCase(SQUARE_2);

        MinesweeperAggregate aggregate = buildAggregate(HINTS_2);

        Assertions.assertEquals(Arrays.stream(aggregate.getHints()).findFirst(), Arrays.stream(handler.handle(useCase).getHints()).findFirst());
    }

    private MinesweeperAggregate buildAggregate(String[] hints){
        return  MinesweeperAggregate.builder()
                .hints(hints)
                .build();

    }
    private MinesweeperUseCase buildUseCase(String[] square){
        return  MinesweeperUseCase.builder()
                .square(square)
                .build();

    }
}

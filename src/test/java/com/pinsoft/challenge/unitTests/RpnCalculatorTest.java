package com.pinsoft.challenge.unitTests;

import com.pinsoft.challenge.domain.aggregate.RpnCalculatorAggregate;
import com.pinsoft.challenge.domain.usecase.RpnCalculatorUseCase;
import com.pinsoft.challenge.domain.usecasehandler.RpnCalculatorUseCaseHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RpnCalculatorTest {

    private static final String EXPRESSION_1 = "20 5 /";
    private static final int RESULT_1 = 4;
    private static final String EXPRESSION_2 = "4 2 + 3 -";
    private static final int RESULT_2 = 3;
    private static final String EXPRESSION_3 = "3 5 8 * 7 + *";
    private static final int RESULT_3 = 141;
    RpnCalculatorUseCaseHandler handler;

    @BeforeEach
    public void setup() {
        handler = new RpnCalculatorUseCaseHandler();
    }

    @Test
    @DisplayName("RPN calculated successfully for expression 1")
    void rpn_calculated_successfully_for_expression_1(){

        RpnCalculatorUseCase useCase = buildUseCase(EXPRESSION_1);

        RpnCalculatorAggregate aggregate = buildAggregate(RESULT_1);

        Assertions.assertEquals(aggregate.getResult(), handler.handle(useCase).getResult());
    }

    @Test
    @DisplayName("RPN calculated successfully for expression 2")
    void rpn_calculated_successfully_for_expression_2(){

        RpnCalculatorUseCase useCase = buildUseCase(EXPRESSION_2);

        RpnCalculatorAggregate aggregate = buildAggregate(RESULT_2);

        Assertions.assertEquals(aggregate.getResult(), handler.handle(useCase).getResult());
    }

    @Test
    @DisplayName("RPN calculated successfully for expression 3")
    void rpn_calculated_successfully_for_expression_3(){

        RpnCalculatorUseCase useCase = buildUseCase(EXPRESSION_3);

        RpnCalculatorAggregate aggregate = buildAggregate(RESULT_3);

        Assertions.assertEquals(aggregate.getResult(), handler.handle(useCase).getResult());
    }

    private RpnCalculatorAggregate buildAggregate(int result){
        return  RpnCalculatorAggregate.builder()
                .result(result)
                .build();

    }
    private RpnCalculatorUseCase buildUseCase(String expression){
        return  RpnCalculatorUseCase.builder()
                .expression(expression)
                .build();

    }
}

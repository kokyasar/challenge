package com.pinsoft.challenge.domain.usecasehandler;

import com.pinsoft.challenge.domain.aggregate.RpnCalculatorAggregate;
import com.pinsoft.challenge.domain.usecase.RpnCalculatorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Stack;

@RequiredArgsConstructor
@Component
public class RpnCalculatorUseCaseHandler {

    private static final String SPLIT = " ";
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    public RpnCalculatorAggregate handle(RpnCalculatorUseCase useCase){

        Stack<Integer> rpnStack = new Stack<>();
        String[] expressionParts = useCase.getExpression().split(SPLIT);

        for (String expressionPart : expressionParts) {
            if (isNumeric(expressionPart)) {
                rpnStack.push(Integer.parseInt(expressionPart));
            } else {
                int operand2 = rpnStack.pop();
                int operand1 = rpnStack.pop();
                int result = applyOperation(operand1, operand2, expressionPart);
                rpnStack.push(result);
            }
        }

        return RpnCalculatorAggregate.builder().result(rpnStack.pop()).build();
    }
    private static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static int applyOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case ADDITION:
                return operand1 + operand2;
            case SUBTRACTION:
                return operand1 - operand2;
            case MULTIPLICATION:
                return operand1 * operand2;
            case DIVISION:
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}

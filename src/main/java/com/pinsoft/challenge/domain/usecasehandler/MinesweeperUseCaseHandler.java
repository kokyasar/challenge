package com.pinsoft.challenge.domain.usecasehandler;

import com.pinsoft.challenge.domain.aggregate.MinesweeperAggregate;
import com.pinsoft.challenge.domain.usecase.MinesweeperUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MinesweeperUseCaseHandler {
    private static final char MINE = '*';
    public MinesweeperAggregate handle(MinesweeperUseCase useCase){

        int rows = useCase.getSquare().length;
        int cols = useCase.getSquare()[0].length();
        char[][] result = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (useCase.getSquare()[i].charAt(j) == MINE) {
                    result[i][j] = MINE;
                } else {

                    int mineCount = countMines(useCase.getSquare(), i, j);
                    result[i][j] = (char) (mineCount + '0');
                }
            }
        }

        String[] hintField = new String[rows];
        for (int i = 0; i < rows; i++) {
            hintField[i] = new String(result[i]);
        }

        return MinesweeperAggregate.builder().hints(hintField).build();
    }

    private static int countMines(String[] square, int row, int col) {
        int mines = 0;
        int rows = square.length;
        int cols = square[0].length();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (square[newRow].charAt(newCol) == MINE) {
                        mines++;
                    }
                }
            }
        }
        return mines;
    }
}

package com.pinsoft.challenge.domain.usecasehandler;

import com.pinsoft.challenge.domain.aggregate.MinesweeperAggregate;
import com.pinsoft.challenge.domain.usecase.MinesweeperUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MinesweeperUseCaseHandler {

    public MinesweeperAggregate handle(MinesweeperUseCase useCase){

        return null;
    }
}

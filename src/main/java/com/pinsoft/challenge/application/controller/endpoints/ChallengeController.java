package com.pinsoft.challenge.application.controller.endpoints;

import com.pinsoft.challenge.application.controller.tranfers.minesweeper.MinesweeperRequestDTO;
import com.pinsoft.challenge.application.controller.tranfers.minesweeper.MinesweeperResponseDTO;
import com.pinsoft.challenge.application.controller.tranfers.rpncalculater.RpnCalculatorRequestDTO;
import com.pinsoft.challenge.application.controller.tranfers.rpncalculater.RpnCalculatorResponseDTO;
import com.pinsoft.challenge.domain.aggregate.MinesweeperAggregate;
import com.pinsoft.challenge.domain.aggregate.RpnCalculatorAggregate;
import com.pinsoft.challenge.domain.usecase.MinesweeperUseCase;
import com.pinsoft.challenge.domain.usecase.RpnCalculatorUseCase;
import com.pinsoft.challenge.domain.usecasehandler.MinesweeperUseCaseHandler;
import com.pinsoft.challenge.domain.usecasehandler.RpnCalculatorUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pinsoft")
public class ChallengeController {

    private final RpnCalculatorUseCaseHandler rpnCalculatorUseCaseHandler;
    private final MinesweeperUseCaseHandler minesweeperUseCaseHandler;


    @PostMapping("/calculate")
    public ResponseEntity<RpnCalculatorResponseDTO> calculateRpn(@RequestBody RpnCalculatorRequestDTO requestDTO){

        RpnCalculatorUseCase useCase = RpnCalculatorUseCase.builder().expression(requestDTO.getExpression()).build();
        RpnCalculatorAggregate aggregate = rpnCalculatorUseCaseHandler.handle(useCase);
        RpnCalculatorResponseDTO responseDTO = RpnCalculatorResponseDTO.builder().result(aggregate.getResult()).build();

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/show-hints")
    public ResponseEntity<MinesweeperResponseDTO> minesweeper(@RequestBody MinesweeperRequestDTO requestDTO){

        MinesweeperUseCase useCase = MinesweeperUseCase.builder().square(requestDTO.getSquare()).build();
        MinesweeperAggregate aggregate = minesweeperUseCaseHandler.handle(useCase);
        MinesweeperResponseDTO responseDTO = MinesweeperResponseDTO.builder().hints(aggregate.getHints()).build();

        return ResponseEntity.ok(responseDTO);
    }
}

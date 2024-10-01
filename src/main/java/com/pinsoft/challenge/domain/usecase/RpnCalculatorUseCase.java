package com.pinsoft.challenge.domain.usecase;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RpnCalculatorUseCase {

   private String expression;
}

package com.rbfactory.bbscore.controller;

import com.rbfactory.bbscore.dto.GameResult;
import com.rbfactory.bbscore.service.calculator.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
public class CalculatorController {

    final CalculatorService service;

    @GetMapping("")
    public GameResult calculate() {
        return service.calculate();
    }
}

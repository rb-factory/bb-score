package com.rbfactory.bbscore.controller;

import com.rbfactory.bbscore.dto.Score;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @GetMapping("")
    public Score calculate(){
        throw new UnsupportedOperationException();
    }
}
